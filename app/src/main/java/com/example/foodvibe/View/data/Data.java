package com.example.foodvibe.View.data;

import com.example.foodvibe.models.Food_Order;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Food_Order> generateFood() {
        ArrayList<Food_Order> allFood = new ArrayList<>();
        allFood.add(new Food_Order("Burger","lettuce ,cranberries,chilli","https://singularityhub.com/wp-content/uploads/2019/04/delicious-tasty-burger-future-of-food-shutterstock-671137990-1068x601.jpg",33,10));
        allFood.add(new Food_Order("Pasta","cloves ,minced,garlic","https://hips.hearstapps.com/hmg-prod/images/delish-bucatinipasta-028-ls-1607552701.jpg",10,100));
        allFood.add(new Food_Order("Pasta","lemon,spaghetti ,cream","https://assets.bonappetit.com/photos/5b9a901947aaaf7cd9ea90f2/4:5/w_2248,h_2810,c_limit/ba-recipe-pasta-al-limone.jpg",22,10));
        allFood.add(new Food_Order("Pasta","olive oil,garlic ,mozzarella","https://images.immediate.co.uk/production/volatile/sites/30/2021/04/Pasta-alla-vodka-f1d2e1c.jpg",31,20));
        allFood.add(new Food_Order("Pasta","chicken ,garlic ,olive oil","https://www.thechunkychef.com/wp-content/uploads/2017/08/One-Pot-Chicken-Parmesan-Pasta-feat-500x450.jpg",42,11));
        allFood.add(new Food_Order("Pasta","olive oil,mushrooms ,butter ","https://www.recipetineats.com/wp-content/uploads/2016/10/Mushroom-Pasta_6-SQ.jpg?w=500&h=500&crop=1",30,8));
        allFood.add(new Food_Order("Pizza","garlic ,mushrooms ,mozzarella","https://upload.wikimedia.org/wikipedia/commons/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg",42,30));
        allFood.add(new Food_Order("Pizza","olive oil,garlic ,mozzarella","https://img.onmanorama.com/content/dam/mm/en/food/features/images/2021/10/17/pizza.jpg",20,21));
        allFood.add(new Food_Order("Pizza","mushrooms ,mozzarella,olive oil","https://images.ctfassets.net/uexfe9h31g3m/6oBxgSjH9KoYuQqS2uO4Kc/a4b920125e77646ca7a573932a6301d6/GLUTEN-FREE-PIZZA.jpg?w=1200&h=600&fm=jpg&fit=thumb&q=90&fl=progressive",40,20));
        allFood.add(new Food_Order("Pizza","mozzarella,garlic ,pepperoni","https://www.seriouseats.com/thmb/h5FSmhowCRHsbwbWpNUEn0AiT-o=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__recipes__images__2016__05__20160503-spicy-spring-pizza-recipe-37-f00f24dc467f4bad82d5434d7c28c12e.jpg",40,20));
        String json = new Gson().toJson(allFood);
        return allFood;
    }
}
