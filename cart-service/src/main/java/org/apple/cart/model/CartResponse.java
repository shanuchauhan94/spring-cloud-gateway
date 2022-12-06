package org.apple.cart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private String id;
    private int noOfItems;
    private Date date;
    private List<Items> itemsList;

}
