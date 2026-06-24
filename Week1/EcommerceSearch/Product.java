package Week1.EcommerceSearch;

import java.util.Arrays;

public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product(ID: " + productId + ", Name: " + productName + ", Category: " + category + ")";
    }

    // for sorting based on the productId
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
}

class SearchAlgorithms {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = sortedProducts[mid];
            if (midProduct.getProductId() == targetId) {
                return midProduct;
            } else if (midProduct.getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        Product[] productArray = {
                new Product(505, "Wireless Mouse", "Electronics"),
                new Product(102, "Running Shoes", "Footwear"),
                new Product(750, "Coffee Maker", "Home Appliances"),
                new Product(301, "Notebook", "Stationery"),
                new Product(210, "Backpack", "Accessories"),
                new Product(450, "Smartphone", "Electronics")
        }; // cant decide on the list of objects so used ai to generate one

        Product[] sortedArray = productArray.clone();
        Arrays.sort(sortedArray); // for this only i have added the compareTo overidden method in the product
                                  // class and thats why i implemented the Comparable interface

        System.out.println("Sorted productArray");
        for (Product p : sortedArray) {
            System.out.println("  " + p);
        }
        int targetId = 210;

        System.out.println("\nlinear search");
        long start = System.nanoTime();
        Product resultLinear = SearchAlgorithms.linearSearch(productArray, targetId);
        long end = System.nanoTime();
        System.out.println("Found: " + resultLinear);
        System.out.printf("Time: %.3f ms\n", (end - start) / 1000000.0);

        System.out.println("binary Search");
        start = System.nanoTime();
        Product resultBinary = SearchAlgorithms.binarySearch(sortedArray, targetId);
        end = System.nanoTime();
        System.out.println("Found: " + resultBinary);
        System.out.printf("time: %.3f ms\n", (end - start) / 1000000.0);// i am using a float format specifier , here
                                                                        // the nano second to ms conversion is needed ,
                                                                        // or else just use the format specifier of long
                                                                        // , cuz nano seconds are huge

    }
}