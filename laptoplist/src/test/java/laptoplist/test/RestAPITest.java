package laptoplist.test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import laptoplist.Laptop;



public class RestAPITest {
	private static final String baseurl="http://localhost:8080/laptoplist/api/laptops/";
	@Before
	public void setUp() {
		UtilsDAOExt utilsDAO = new UtilsDAOExt();
		utilsDAO.deleteTable();
		utilsDAO.addTwoRows();
	}

	@Test
	public void testGetWines() {
		String url=baseurl;
		RestResponse response = RestApiHelper.performGetRequest(url, null);
		assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Laptop	[] laptops = new Gson().fromJson(response.getResponseBody(),
				Laptop[].class);
		assertEquals(2, laptops.length);
		Laptop laptop = laptops[0];
//		Assert.assertEquals("CHATEAU DE SAINT COSME", wine.getName());
//		Assert.assertEquals("France", wine.getCountry());
//		Assert.assertEquals("Southern Rhone / Gigondas", wine.getRegion());
//		Assert.assertEquals("excellent complement to fish dishes",
//				wine.getDescription());
		laptop = laptops[1];
//		Assert.assertEquals("LAN RIOJA CRIANZA", wine.getName());
//		Assert.assertEquals("Spain", wine.getCountry());
//		Assert.assertEquals("Rioja", wine.getRegion());
	}

	@Test
	public void testGetWineWithId() {
		String url = baseurl+"1";
		RestResponse response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		/**
		 * 1. Use GSON builder class to get the instance of GSON class 2. Use
		 * the GSON object to deserialize the json
		 */
		Laptop l = new Gson().fromJson(response.getResponseBody(), Laptop.class);
//		Assert.assertEquals("CHATEAU DE SAINT COSME", wine.getName());
//		Assert.assertEquals("France", wine.getCountry());
//		Assert.assertEquals("Southern Rhone / Gigondas", wine.getRegion());
	}

	@Test
	public void testPostWine() {
		String fileName = "TestDataFile.txt";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		RestResponse response = RestApiHelper.performPostRequest(
				baseurl, fileName,
				headers);
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
		Laptop l = new Gson().fromJson(response.getResponseBody(), Laptop.class);
		String url = baseurl
				+ l.getLId();
		response = RestApiHelper.performGetRequest(url, null);
//		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
//		Assert.assertEquals("CHATEAU DE ATHLONE", wine.getName());
//		Assert.assertEquals("Athlone / Tullamore", wine.getGrapes());
//		Assert.assertEquals("Midlands / East", wine.getRegion());
//		Assert.assertEquals("2017", wine.getYear());
//		Assert.assertEquals("saint_cosme.jpg", wine.getPicture());
//		Assert.assertEquals("This wine in not drinkable.",
//				wine.getDescription());
	}

	@Test
	public void testPutWine() {
		String fileName = "TestDataPut.txt";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		String url = baseurl+"1";
		RestResponse response = RestApiHelper.performPutRequest(url, fileName,
				headers);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Laptop l = new Gson().fromJson(response.getResponseBody(), Laptop.class);
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
//		Assert.assertEquals("CHATEAU DE SAINT COSME", wine.getName());
//		Assert.assertEquals("Grenache / Syrah", wine.getGrapes());
//		Assert.assertEquals("France", wine.getCountry());
//		Assert.assertEquals("Athlone", wine.getRegion());
//		Assert.assertEquals("2017", wine.getYear());
//		Assert.assertEquals("saint_cosme.jpg", wine.getPicture());
//		Assert.assertEquals("This wine has improved.", wine.getDescription());
	}

	@Test
	public void testDeleteWine() {
		String url = baseurl+"1";
		RestResponse response = RestApiHelper.performDeleteRequest(url);
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
		Laptop laptop = new Gson().fromJson(response.getResponseBody(), Laptop.class);
		Assert.assertEquals(null, laptop);
		url = baseurl;
		response = RestApiHelper.performGetRequest(url, null);
		assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Laptop[] laptops = new Gson().fromJson(response.getResponseBody(),
				Laptop[].class);
		assertEquals(1, laptops.length);
	}
}

 