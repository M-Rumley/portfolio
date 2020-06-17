package com.sg.fixmastery;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.fixmastery.contract.Contract;
import com.sg.fixmastery.contract.ContractRepository;
import com.sg.fixmastery.fix.Fix;
import com.sg.fixmastery.fix.FixRepository;
import com.sg.fixmastery.instrument.Instrument;
import com.sg.fixmastery.instrument.InstrumentRepository;
import com.sg.fixmastery.mic.Mic;
import com.sg.fixmastery.mic.MicRepository;
import com.sg.fixmastery.orders.Orders;
import com.sg.fixmastery.orders.OrdersRepository;
import com.sg.fixmastery.product.Product;
import com.sg.fixmastery.product.ProductRepository;
import com.sg.fixmastery.ric.Ric;
import com.sg.fixmastery.ric.RicRepository;

@RestController
public class ApplicationRestController {

	@Autowired
	InstrumentRepository instrumentRepository;
	@Autowired
	RicRepository ricRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	MicRepository micRepository;
	@Autowired
	FixRepository fixRepository;
	@Autowired
	ContractRepository contractRepository;

	@RequestMapping("/instruments")
	Collection<Instrument> instruments() {
		return this.instrumentRepository.findAll();
	}

	@RequestMapping("/instruments/apple")
	Collection<Instrument> getApple() {
		return this.instrumentRepository.getApple();
	}

	@RequestMapping("/ric")
	Collection<Ric> rics() {
		return this.ricRepository.findAll();
	}

	@RequestMapping("/product")
	Collection<Product> products() {
		return this.productRepository.findAll();
	}

	@RequestMapping("/orders")
	Collection<Orders> orders() {
		return this.ordersRepository.findAll();
	}

	@RequestMapping("/mic")
	Collection<Mic> mics() {
		return this.micRepository.findAll();
	}

	@RequestMapping("/fix")
	Collection<Fix> fixes() {
		return this.fixRepository.findAll();
	}

	@RequestMapping("/contracts")
	Collection<Contract> contracts() {
		return this.contractRepository.findAll();
	}
}
