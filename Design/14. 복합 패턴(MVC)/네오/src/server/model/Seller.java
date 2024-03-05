package server.model;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {

    private final UUID id;
    private String name;
    private final WareHouse wareHouse;
    private final Lock lock;

    public Seller(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.wareHouse = new WareHouse();
        this.lock = new ReentrantLock();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock(UUID productId) {
        return wareHouse.getStock(productId);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(Product product, int amount) {
        lock.lock();
        try {
            wareHouse.add(product, amount);
        } finally {
            lock.unlock();
        }
    }

    public void removeProduct(UUID productId) {
        lock.lock();
        try {
            wareHouse.remove(productId);
        } finally {
            lock.unlock();
        }
    }

    public void sell(UUID productId, int amount) {
        lock.lock();
        try {
            wareHouse.sub(productId, amount);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
