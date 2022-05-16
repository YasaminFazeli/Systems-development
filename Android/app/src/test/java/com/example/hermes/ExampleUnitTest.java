package com.example.hermes;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

import static junit.framework.Assert.assertEquals;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ExampleUnitTest {

    JsonManager jManager = new JsonManager();
    ArrayList<Delivery> deliveries = new ArrayList<>();
    Delivery delivery1 = new Delivery();
    Delivery delivery2 = new Delivery();
    Delivery delivery3 = new Delivery();
    Delivery delivery4 = new Delivery();
    Delivery delivery5 = new Delivery();
    Delivery delivery6 = new Delivery();
    Delivery delivery7 = new Delivery();
    Delivery delivery8 = new Delivery();
    Delivery delivery9 = new Delivery();
    Delivery delivery10 = new Delivery();

    @Before
    public void setUp() throws ParseException {

        //Setup for Json tests
        delivery1.setCustomerID("Emrik");
        delivery1.setDate("20221104 13:45:00");

        //Setup for sorting tests
        deliveries.add(delivery1);
        delivery2.setCustomerID("Erik");
        delivery2.setDate("20110912 08:23:55");
        deliveries.add(delivery2);
        delivery3.setCustomerID("Amin");
        delivery3.setDate("20222104 13:45:00");
        deliveries.add(delivery3);
        delivery4.setCustomerID("nihiliss");
        delivery4.setDate("20221120 09:15:02");
        deliveries.add(delivery4);
        delivery5.setCustomerID("Julia");
        delivery5.setDate("20110612 08:23:55");
        deliveries.add(delivery5);
        delivery6.setCustomerID("Yasamin");
        delivery6.setDate("20220113 12:11:56");
        deliveries.add(delivery6);
        delivery7.setCustomerID("Daniel");
        delivery7.setDate("20220113 00:11:56");
        deliveries.add(delivery7);
        delivery8.setCustomerID("Sven");
        delivery8.setDate("19800627 16:00:17");
        deliveries.add(delivery8);
        delivery9.setCustomerID("Karl");
        delivery9.setDate("20240520 09:35:08");
        deliveries.add(delivery9);
        delivery10.setCustomerID("Björn");
        delivery10.setDate("20220512 23:13:44");
        deliveries.add(delivery10);

    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void gettingJsonObject(){
        JSONObject actualObject = jManager.readJsonObject("src/main/java/com/example/hermes/data/test.Json");
        JSONObject expectedObject = createExpectedObject();

        assertEquals(expectedObject.toString(), actualObject.toString());
    }

    @Test
    public void writeJson() throws JSONException {
        jManager.writeDelivery(delivery1, "src/main/java/com/example/hermes/data/test.Json");
        JSONObject jsonObject = jManager.readJsonObject("src/main/java/com/example/hermes/data/test.Json");
        JSONArray array = (JSONArray) jsonObject.get("deliveries");
        JSONObject expectedObject = createExpectedObject();

        try (FileWriter file = new FileWriter("src/main/java/com/example/hermes/data/test.Json")){
            file.write(expectedObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(array.get(0), array.get(1));
    }

    @Test
    public void sortDeliveries(){
        ArrayList<Delivery> oldest = new ArrayList<>(deliveries);
        oldest.sort(Delivery.byOldest);
        ArrayList<Delivery> newest = new ArrayList<>(deliveries);
        newest.sort(Delivery.byNewest);
        ArrayList<Delivery> a_z = new ArrayList<>(deliveries);
        a_z.sort(Delivery.byName);
        ArrayList<Delivery> z_a = new ArrayList<>(deliveries);
        z_a.sort(Delivery.byNameReverse);

        ArrayList<Delivery> expectedOldest = new ArrayList<>();
        expectedOldest.add(deliveries.get(7));
        expectedOldest.add(deliveries.get(4));
        expectedOldest.add(deliveries.get(1));
        expectedOldest.add(deliveries.get(6));
        expectedOldest.add(deliveries.get(5));
        expectedOldest.add(deliveries.get(9));
        expectedOldest.add(deliveries.get(0));
        expectedOldest.add(deliveries.get(3));
        expectedOldest.add(deliveries.get(2));
        expectedOldest.add(deliveries.get(8));
        ArrayList<Delivery> expectedNewest = new ArrayList<>();
        expectedNewest.add(deliveries.get(8));
        expectedNewest.add(deliveries.get(2));
        expectedNewest.add(deliveries.get(3));
        expectedNewest.add(deliveries.get(0));
        expectedNewest.add(deliveries.get(9));
        expectedNewest.add(deliveries.get(5));
        expectedNewest.add(deliveries.get(6));
        expectedNewest.add(deliveries.get(1));
        expectedNewest.add(deliveries.get(4));
        expectedNewest.add(deliveries.get(7));
        ArrayList<Delivery> expectedByName = new ArrayList<>();
        expectedByName.add(deliveries.get(2));
        expectedByName.add(deliveries.get(9));
        expectedByName.add(deliveries.get(6));
        expectedByName.add(deliveries.get(0));
        expectedByName.add(deliveries.get(1));
        expectedByName.add(deliveries.get(4));
        expectedByName.add(deliveries.get(8));
        expectedByName.add(deliveries.get(3));
        expectedByName.add(deliveries.get(7));
        expectedByName.add(deliveries.get(5));
        ArrayList<Delivery> expectedByReverseName = new ArrayList<>();
        expectedByReverseName.add(deliveries.get(5));
        expectedByReverseName.add(deliveries.get(7));
        expectedByReverseName.add(deliveries.get(3));
        expectedByReverseName.add(deliveries.get(8));
        expectedByReverseName.add(deliveries.get(4));
        expectedByReverseName.add(deliveries.get(1));
        expectedByReverseName.add(deliveries.get(0));
        expectedByReverseName.add(deliveries.get(6));
        expectedByReverseName.add(deliveries.get(9));
        expectedByReverseName.add(deliveries.get(2));

        assertEquals(expectedOldest, oldest);
        assertEquals(expectedNewest, newest);
        assertEquals(expectedByName, a_z);
        assertEquals(expectedByReverseName, z_a);
    }

    private JSONObject createExpectedObject(){
        JSONObject expectedObject = new JSONObject();
        JSONObject deliveryDetails = new JSONObject();
        JSONObject delivery = new JSONObject();
        JSONArray array = new JSONArray();

        deliveryDetails.put("date", "2022 Nov 04");
        deliveryDetails.put("customerID", "Emrik");
        deliveryDetails.put("time", "13:45:00");
        delivery.put("delivery", deliveryDetails);
        array.add(delivery);
        expectedObject.put("deliveries", array);
        return expectedObject;
    }
}
