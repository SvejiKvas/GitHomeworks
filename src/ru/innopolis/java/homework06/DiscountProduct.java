package ru.innopolis.java.homework06;

public class DiscountProduct extends Product {
    private int discount;

    public DiscountProduct (String name, int discount) {
        super(name);
        validateNewVar(discount);
        this.discount = discount;
        this.setPrice(calculateDiscountPrice(this.discount));
    }

    public DiscountProduct(Product product) {
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.discount = 0;
    }

    public DiscountProduct(String allInfo) {
        String[] strMas = allInfo.split("[=,]");
        String name = strMas[0].trim();

        int price = Integer.parseInt(strMas[1].trim());
        int discount = Integer.parseInt(strMas[2].trim().replaceAll("%", ""));

        validateNewVar(discount);

        this.discount = discount;

        setName(name);
        setPrice(price);
    }

    private void validateNewVar(int discount) {
        if (discount <= 0) {
            throw new IllegalArgumentException("Скидка не может быть ниже или равна нулю");
        }
    }

    private int calculateDiscountPrice(int discount) {
        return super.getPrice() - super.getPrice() * discount / 100;
    }

    @Override
    public String toString() {
        return String.format(
                        "Name: %s%n" +
                        "Price: %s%n" +
                        "Discount: %s" + "%%" + "\n",
                this.getName(), this.getPrice(), this.discount
        );
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
