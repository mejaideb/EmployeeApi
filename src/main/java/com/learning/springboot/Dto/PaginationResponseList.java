package com.learning.springboot.Dto;

import com.learning.springboot.Model.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponseList<T> {
    List<T> responseList;
    int pageNumber;
    int pageSize;
    int totalPages;
    String sortBy;
    OrderBy orderBy;
}
