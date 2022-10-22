package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import org.junit.jupiter.api.Assertions;

public class StoreTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final int PRC = 10;
    private static final int PRCONE = 15;
    private static final int PRCTWO = 50;
//    private Tulip tul;
//    private Rose rose;
//    private Chamomile chamo;
    private Store s;
    private FlowerBucket bucketOne;
    private FlowerBucket bucketTwo;
    private FlowerBucket bucketThree;

    private FlowerPack pckOne;
    private FlowerPack pckTwo;
    private FlowerPack pckThree;

    @BeforeEach
    public void init() {

        Tulip tul = new Tulip();
        Chamomile chamo = new Chamomile();
        Rose rose = new Rose();
        s = new Store();
        bucketOne = new FlowerBucket();
        bucketTwo = new FlowerBucket();
        bucketThree = new FlowerBucket();
        pckOne = new FlowerPack(tul, PRC);
        pckTwo = new FlowerPack(rose, PRCONE);
        pckThree = new FlowerPack(chamo, PRCTWO);
    }

    @Test
    public void testSearch() {

//        Random RANDOM_GENERATOR = new Random();
//        int MAX_PRICE = 100;
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
//        int amount = RANDOM_GENERATOR.nextInt(MAX_PRICE);

        Tulip tul = new Tulip();
        Chamomile chamo = new Chamomile();
        Rose rose = new Rose();

        tul.setPrice(price);
        tul.setColor(FlowerColor.YELLOW);

        rose.setPrice(price);
        rose.setColor(FlowerColor.RED);

        chamo.setPrice(price);
        chamo.setColor(FlowerColor.WHITE);

//        Store s = new Store();
//        FlowerBucket bucketOne = new FlowerBucket();
//        FlowerBucket bucketTwo = new FlowerBucket();
//        FlowerBucket bucketThree = new FlowerBucket();
//        FlowerPack pckOne = new FlowerPack(tul, 10);
//        FlowerPack pckTwo = new FlowerPack(rose, 15);
//        FlowerPack pckThree = new FlowerPack(chamo, 50);
        
        pckOne = new FlowerPack(tul, PRC);
        pckTwo = new FlowerPack(rose, PRCONE);
        pckThree = new FlowerPack(chamo, PRCTWO);

        bucketOne.add(pckOne);
        bucketOne.add(pckTwo);
        bucketTwo.add(pckTwo);
        bucketTwo.add(pckOne);
        bucketTwo.add(pckThree);
        bucketThree.add(pckThree);
        bucketThree.add(pckTwo);

        s.addBucket(bucketOne);
        s.addBucket(bucketTwo);
        s.addBucket(bucketThree);

        Assertions.assertEquals(true, s.search(bucketOne));
        Assertions.assertEquals(true, s.search(bucketTwo));
        Assertions.assertEquals(true, s.search(bucketThree));
        Assertions.assertEquals(false, s.search(bucketOne));
        Assertions.assertEquals(false, s.search(bucketTwo));
        Assertions.assertEquals(false, s.search(bucketThree));
    }
}
