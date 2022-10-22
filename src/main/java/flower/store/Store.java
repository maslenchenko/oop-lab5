package flower.store;

import java.util.ArrayList;

public class Store {
    private ArrayList<FlowerBucket> buckets = new ArrayList<FlowerBucket>();

    public void addBucket(FlowerBucket bucket) {
        buckets.add(bucket);
    }

    public boolean search(FlowerBucket bucket) {
        for (int i = 0; i < buckets.size(); ++i) {
            if ((buckets.get(i).getChamomiles() == bucket.getChamomiles()) && (buckets.get(i).getRoses() == bucket.getRoses()) && (buckets.get(i).getTulips() == bucket.getTulips())) {
                buckets.remove(i);
                return true;
            }
        }
        return false;
    }
}
