package laptoplist.test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

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
	public void testGetLaptops() {
		String url=baseurl;
		RestResponse response = RestApiHelper.performGetRequest(url, null);
		assertEquals(HttpStatus.SC_OK, response.getStatusCode());
//		System.out.println("Response:\n"+response.getResponseBody());
		Laptop	[] laptops = new Gson().fromJson(response.getResponseBody(),
				Laptop[].class);
		assertEquals(4, laptops.length);
		
		Laptop laptop = laptops[0];
		assertEquals(120, laptop.getAdapterPower());
		assertEquals("Core i7 4700MQ", laptop.getCpu());
		assertEquals("GTX860M", laptop.getGpu());
		assertEquals(Laptop.KBLType.monochrome ,laptop.getKbBacklight());
		assertEquals(4, laptop.getMainMem());
		assertEquals("Clevo", laptop.getManufacturer());
		assertEquals("1920x1080", laptop.getScreenResolution());
		assertEquals(new BigDecimal("13.3"), laptop.getScreenSize());
		assertEquals(500, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.SSD, laptop.getStorageType());
		assertEquals(new Double(2.0), new Double(laptop.getVideoMem()));
		assertEquals(new Double(2.5), new Double(laptop.getWeight()));
		assertEquals(1l, laptop.getLId());
		assertEquals("w230ss", laptop.getLModel());
		
		laptop = laptops[1];
		assertEquals(150, laptop.getAdapterPower());
		assertEquals("Core i7 4700MQ", laptop.getCpu());
		assertEquals("GTX950M", laptop.getGpu());
		assertEquals(Laptop.KBLType.none ,laptop.getKbBacklight());
		assertEquals(8, laptop.getMainMem());
		assertEquals("Clevo", laptop.getManufacturer());
		assertEquals("1920x1080", laptop.getScreenResolution());
		assertEquals(new BigDecimal("15.6"), laptop.getScreenSize());
		assertEquals(500, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.HDD, laptop.getStorageType());
		assertEquals(new Double(2.0), new Double(laptop.getVideoMem()));
		assertEquals(new Double(2.6), new Double(laptop.getWeight()));
		assertEquals(2l, laptop.getLId());
		assertEquals("w650sc", laptop.getLModel());
		
		laptop = laptops[2];
		assertEquals(65, laptop.getAdapterPower());
		assertEquals("Core i5 5200U", laptop.getCpu());
		assertEquals("GT 940M", laptop.getGpu());
		assertEquals(Laptop.KBLType.none ,laptop.getKbBacklight());
		assertEquals(4, laptop.getMainMem());
		assertEquals("ASUS", laptop.getManufacturer());
		assertEquals("1920x1080", laptop.getScreenResolution());
		assertEquals(new BigDecimal("14.1"), laptop.getScreenSize());
		assertEquals(500, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.HDD, laptop.getStorageType());
		assertEquals(new Double(2.0), new Double(laptop.getVideoMem()));
		assertEquals(new Double(1.8), new Double(laptop.getWeight()));
		assertEquals(3l, laptop.getLId());
		assertEquals("A401L", laptop.getLModel());
		
		laptop = laptops[3];
		assertEquals(180, laptop.getAdapterPower());
		assertEquals("Core i7 4710HQ", laptop.getCpu());
		assertEquals("GTX980M", laptop.getGpu());
		assertEquals(Laptop.KBLType.color ,laptop.getKbBacklight());
		assertEquals(8, laptop.getMainMem());
		assertEquals("Clevo", laptop.getManufacturer());
		assertEquals("2560x1440", laptop.getScreenResolution());
		assertEquals(new BigDecimal("17.3"), laptop.getScreenSize());
		assertEquals(750, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.SSD, laptop.getStorageType());
		assertEquals(new Double(6.0), new Double(laptop.getVideoMem()));
		assertEquals(new Double(2.8), new Double(laptop.getWeight()));
		assertEquals(4l, laptop.getLId());
		assertEquals("p670sg", laptop.getLModel());
	}

	@Test
	public void testGetLaptopById() {
		String url = baseurl+"3";
		RestResponse response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		/**
		 * 1. Use GSON builder class to get the instance of GSON class 2. Use
		 * the GSON object to deserialize the json
		 */
		Laptop laptop = new Gson().fromJson(response.getResponseBody(), Laptop.class);
		assertEquals(65, laptop.getAdapterPower());
		assertEquals("Core i5 5200U", laptop.getCpu());
		assertEquals("GT 940M", laptop.getGpu());
		assertEquals(Laptop.KBLType.none ,laptop.getKbBacklight());
		assertEquals(4, laptop.getMainMem());
		assertEquals("ASUS", laptop.getManufacturer());
		assertEquals("1920x1080", laptop.getScreenResolution());
		assertEquals(new BigDecimal("14.1"), laptop.getScreenSize());
		assertEquals(500, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.HDD, laptop.getStorageType());
		assertEquals(new Double(2.0), new Double(laptop.getVideoMem()));
		assertEquals(new Double(1.8), new Double(laptop.getWeight()));
		assertEquals(3l, laptop.getLId());
		assertEquals("A401L", laptop.getLModel());
//		
	}

	@Test
	public void testPostLaptop() {
		String fileName = "PostTestData.txt";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		RestResponse response = RestApiHelper.performPostRequest(
				baseurl, fileName,
				headers);
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
		Laptop laptop = new Gson().fromJson(response.getResponseBody(), Laptop.class);
		String url = baseurl
				+ laptop.getLId();
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		assertEquals(230, laptop.getAdapterPower());
		assertEquals("Core i7 6700K", laptop.getCpu());
		assertEquals("GTX970M", laptop.getGpu());
		assertEquals(Laptop.KBLType.color ,laptop.getKbBacklight());
		assertEquals(8, laptop.getMainMem());
		assertEquals("MSI", laptop.getManufacturer());
		assertEquals("2560x1440", laptop.getScreenResolution());
		assertEquals(new BigDecimal("15.6"), laptop.getScreenSize());
		assertEquals(750, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.HDD, laptop.getStorageType());
		assertEquals(new Double(3.5), new Double(laptop.getVideoMem()));
		assertEquals(new Double(2.6), new Double(laptop.getWeight()));
		assertEquals("16L1", laptop.getLModel());
	}

	@Test
	public void testPutLaptop() {
		String fileName = "PutTestData.txt";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		String url = baseurl+"1";
		RestResponse response = RestApiHelper.performPutRequest(url, fileName,
				headers);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Laptop laptop = new Gson().fromJson(response.getResponseBody(), Laptop.class);
		response = RestApiHelper.performGetRequest(url, null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		assertEquals(180, laptop.getAdapterPower());
		assertEquals("Core i7 4710HQ", laptop.getCpu());
		assertEquals("GTX970M", laptop.getGpu());
		assertEquals(Laptop.KBLType.color ,laptop.getKbBacklight());
		assertEquals(8, laptop.getMainMem());
		assertEquals("Clevo", laptop.getManufacturer());
		assertEquals("1920x1080", laptop.getScreenResolution());
		assertEquals(new BigDecimal("15.6"), laptop.getScreenSize());
		assertEquals(750, laptop.getStorageSize());
		assertEquals(Laptop.StorageType.HDD, laptop.getStorageType());
		assertEquals(new Double(3.5), new Double(laptop.getVideoMem()));
		assertEquals(new Double(2.6), new Double(laptop.getWeight()));
		assertEquals("p650sg", laptop.getLModel());
	}

	@Test
	public void testDeleteLaptop() {
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
		assertEquals(3, laptops.length);
	}
}

 