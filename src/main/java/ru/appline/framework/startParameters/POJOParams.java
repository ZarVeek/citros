package ru.appline.framework.startParameters;

import lombok.Data;


/** для чтения json */
@Data
public class POJOParams {
    private String productForSearch;
    private String productForCheck;
    private String sortType;
}
