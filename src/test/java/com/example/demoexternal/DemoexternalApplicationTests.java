package com.example.demoexternal;

import com.example.demoexternal.enums.TransferRequestStatus;
import com.example.demoexternal.model.TransferRequest;
import com.example.demoexternal.repository.ITransferRepositoryDao;
import com.example.demoexternal.repository.TransferRepository;
import com.example.demoexternal.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoexternalApplicationTests {

	@Autowired
	private TransferRepository repository;

	@Autowired
	private TransferService service;

	@Autowired
	private ITransferRepositoryDao transferRepositoryDao;

	@Test
	public void contextLoads() {
		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setAmount(BigDecimal.TEN);
		transferRequest.setCurrency("USD");
		transferRequest.setPaymentSystem("Bepaid");
		transferRequest.setTargetWallet("34242354345346546");
		transferRequest.setTransferRequestId("some id");
		transferRequest.setStatus(TransferRequestStatus.WAITING);

		repository.save(transferRequest);
	}

	@Test
	public void testGetTransfer() {
//		List<RawTransferRequest> all = repository.findAll();
//		System.out.println(all);
	}

	@Test
	public void test() {
		String url = "https://www.iex2.net/v2/asset/withdraw?currencyId=7&addressId=";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity httpEntity = getHttpEntity();
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		System.out.println(exchange.getBody());
	}

	private HttpEntity getHttpEntity() {
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJvcDAxMDE1NTI0Njg0MTI1Mzk2MzkwNDhDMTUwMzA0RDdBVU9kUyIsInVpZCI6InUvUW5KdklNNGFMd2dLUUVNUkxpb1E9PSIsInN0YSI6MCwibWlkIjowLCJpYXQiOjE1NTI0Njg0MTIsImV4cCI6MTU1MzA3MzIxMiwiYmlkIjoxNDEsImRvbSI6Ind3dy5pZXgyLm5ldCIsImlzcyI6Im9rY29pbiIsInN1YiI6IjZGNThBNEUwMkExQjEwODBEQTkxQjk4RkNBRUYwRUMzIn0.jFyZuO9ADRxLQcQicIKfsg0Wx2aXzGp-3IisP2Lf3ZTOXZguJH3Bqa6EaJhu0h15cdnVQU1o8MEM4viwwSRDow";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("Referer", "https://www.iex2.net/account/balance/wallet/withdrawCurrency");
		return new HttpEntity<>(headers);
	}

	@Test
	public void testService() {
//		service.first();
		service.updateStatus("5c8a2d9a875d333c48c2ef24");
	}

	@Test
	public void testUpdateTransferRequest() {
		String transferId = "5c8a2d9a875d333c48c2ef24";
		boolean result = transferRepositoryDao.findAndModifyByIdAndStatus(transferId, TransferRequestStatus.WAITING.name());
		System.out.println(result);
	}
}
