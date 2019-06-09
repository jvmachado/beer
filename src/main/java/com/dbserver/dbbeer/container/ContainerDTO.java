package com.dbserver.dbbeer.container;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ContainerDTO implements Serializable {

	private static final long serialVersionUID = 5683612261777621133L;

	private BigDecimal temperature;

	private Integer beerType;

	private Boolean isOutRange;
}
