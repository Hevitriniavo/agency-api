package com.fresh.coding.agencyapi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    private String description;

    private Double price;

    private Integer area;

    private String type;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String city;

    private String postalCode;

    @Column(nullable = false)
    private LocalDateTime creationDate;


    @Column(nullable = false)
    private Boolean availability;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();


    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
    }
}
