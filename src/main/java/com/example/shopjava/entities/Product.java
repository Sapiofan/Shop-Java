package com.example.shopjava.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@OnDelete(action = OnDeleteAction.CASCADE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String payment;

    @Column(nullable = false)
    private Float rating;

    @Column
    private Integer discount;

    @Column
    private String gifts;

    @Column(nullable = false)
    private Boolean isAvailable;

    @Column(nullable = false)
    private Integer warranty;

//    @Column
//    private Date addedAt;

    @Column
    private Integer sold;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "cartProducts")
    private Set<Cart> carts = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "favoriteProducts")
    private Set<Favorite> favorites = new HashSet<>();

    public Product() {
    }

    public Product(String image, String name, Float price, String brand, String payment, Float rating,
                   Integer discount, String gifts, Boolean isAvailable, Integer warranty, Date addedAt,
                   Integer sold, Category category) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.payment = payment;
        this.rating = rating;
        this.discount = discount;
        this.gifts = gifts;
        this.isAvailable = isAvailable;
        this.warranty = warranty;
//        this.addedAt = addedAt;
        this.sold = sold;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getGifts() {
        return gifts;
    }

    public void setGifts(String gifts) {
        this.gifts = gifts;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.category.addProduct(this);
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

//    public Date getAddedAt() {
//        return addedAt;
//    }
//
//    public void setAddedAt(Date addedAt) {
//        this.addedAt = addedAt;
//    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

//    public void addFavorite(Favorite favorite){
//        this.favorites.add(favorite);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(brand, product.brand) && Objects.equals(payment, product.payment) && Objects.equals(rating, product.rating) && Objects.equals(discount, product.discount) && Objects.equals(gifts, product.gifts) && Objects.equals(isAvailable, product.isAvailable) && Objects.equals(warranty, product.warranty) && Objects.equals(category, product.category) && Objects.equals(reviews, product.reviews) && Objects.equals(carts, product.carts) && Objects.equals(favorites, product.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, brand, payment, rating, discount, gifts, isAvailable, warranty, category, reviews, carts, favorites);
    }
}
