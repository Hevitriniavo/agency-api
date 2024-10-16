package com.fresh.coding.agencyapi.controllers.searchs;

import com.fresh.coding.agencyapi.dtos.pagination.Paginate;
import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.dtos.seachs.PropertySearch;
import com.fresh.coding.agencyapi.dtos.seachs.UserSearch;
import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.services.searchs.SearchWithPaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class SearchWithPaginationController {
    private final SearchWithPaginationService searchWithPaginationService;

    @GetMapping("/users/paginate")
    public Paginate<List<UserDTO>> paginateUsers(
            @ModelAttribute UserSearch userSearch,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return searchWithPaginationService.paginateUsers(userSearch, page, size);
    }

    @GetMapping("/properties/paginate")
    public Paginate<List<PropertyDTO>> paginateProperties(
            @ModelAttribute PropertySearch propertySearch,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return searchWithPaginationService.paginateProperties(propertySearch, page, size);
    }
}
