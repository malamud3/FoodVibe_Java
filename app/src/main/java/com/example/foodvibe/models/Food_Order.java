package com.example.foodvibe.models;

public class Food_Order {
    private String name = "";
    private String ingredients ="";
    private String image = ""; // link
    private int estimated_shipping_time = 0;// min
    private int price ;
    private int rating ;
    private boolean favorite;
  //  private String userName;

    public Food_Order(String name,String ingredients, String image,int estimated_shipping_time,int price) {
    this.name=name;
    this.ingredients=ingredients;
    this.image=image;
    this.estimated_shipping_time=estimated_shipping_time;
    this.price=price;
    this.rating=0;// 0 - 100
    this.favorite=favorite= false;
    }

    @Override
    public String toString() {
        return "Food_Order{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", image='" + image + '\'' +
                ", estimated_shipping_time=" + estimated_shipping_time +
                ", price=" + price +
                ", rating=" + rating +
                ", favorite=" + favorite +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEstimated_shipping_time() {
        return estimated_shipping_time;
    }

    public void setEstimated_shipping_time(int estimated_shipping_time) {
        this.estimated_shipping_time = estimated_shipping_time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
