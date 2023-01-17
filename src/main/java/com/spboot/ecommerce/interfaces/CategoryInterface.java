/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.ecommerce.interfaces;

import com.spboot.ecommerce.models.Category;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface CategoryInterface {
    List<Category> getAll();
}
