package com.fresh.coding.agencyapi.services.searchs;

import com.fresh.coding.agencyapi.dtos.pagination.Paginate;
import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.dtos.seachs.PropertySearch;
import com.fresh.coding.agencyapi.dtos.seachs.UserSearch;
import com.fresh.coding.agencyapi.dtos.users.UserDTO;

import java.util.List;

public interface SearchWithPaginationService {
    Paginate<List<UserDTO>> paginateUsers(UserSearch userSearch, int page, int size);

    Paginate<List<PropertyDTO>> paginateProperties(PropertySearch propertySearch, int page, int size);
}
