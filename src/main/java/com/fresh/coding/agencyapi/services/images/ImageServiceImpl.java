package com.fresh.coding.agencyapi.services.images;

import com.fresh.coding.agencyapi.dtos.images.ImageDTO;
import com.fresh.coding.agencyapi.entities.Image;
import com.fresh.coding.agencyapi.entities.Property;
import com.fresh.coding.agencyapi.exceptions.HttpNotFoundException;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final RepositoryFactory repositoryFactory;

    @Value("${path.upload.dir}")
    private String uploadDir;

    @Override
    @SneakyThrows
    public ImageDTO uploadImage(MultipartFile file, Long propertyId) {
        String fileName = file.getOriginalFilename();
        Path path = Paths.get(uploadDir, fileName);
        Files.createDirectories(path.getParent());

        @Cleanup var inputStream = file.getInputStream();
        Files.copy(inputStream, path);

        var propertyRepo = repositoryFactory.getPropertyRepository();
        var property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new HttpNotFoundException("Property not found"));

        var image = new Image();
        image.setThumbnail(fileName);
        image.setProperty(property);

        var imageRepo = repositoryFactory.getImageRepository();
        image = imageRepo.save(image);

        return mapToDTO(image);
    }

    @Override
    @SneakyThrows
    public ImageDTO updateImage(Long id, MultipartFile file, Long propertyId) {
        var imageRepo = repositoryFactory.getImageRepository();
        var optionalImage = imageRepo.findById(id);

        if (optionalImage.isPresent()) {
            var image = optionalImage.get();

            var oldFileName = image.getThumbnail();
            Path oldFilePath = Paths.get(uploadDir, oldFileName);
            if (Files.exists(oldFilePath)) {
                Files.delete(oldFilePath);
            }

            var newFileName = file.getOriginalFilename();
            var newPath = Paths.get(uploadDir, newFileName);

            @Cleanup var inputStream = file.getInputStream();
            Files.copy(inputStream, newPath);

            image.setThumbnail(newFileName);
            Property property = repositoryFactory.getPropertyRepository().findById(propertyId)
                    .orElseThrow(() -> new HttpNotFoundException("Property not found"));
            image.setProperty(property);

            image = imageRepo.save(image);
            return mapToDTO(image);
        } else {
            throw new HttpNotFoundException("Image not found");
        }
    }

    @Override
    @SneakyThrows
    public void deleteImage(Long id) {
        var imageRepo = repositoryFactory.getImageRepository();
        var optionalImage = imageRepo.findById(id);
        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            String fileName = image.getThumbnail();
            Path filePath = Paths.get(uploadDir, fileName);

            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }

            imageRepo.delete(image);
        } else {
            throw new HttpNotFoundException("Image not found");
        }
    }

    private ImageDTO mapToDTO(Image image) {
        return BeanUtils.map(image, ImageDTO.class);
    }
}
