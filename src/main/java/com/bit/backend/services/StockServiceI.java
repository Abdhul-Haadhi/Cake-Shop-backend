package com.bit.backend.services;

import com.bit.backend.dtos.GrnAddedDto;
import com.bit.backend.dtos.StockDto;

import java.util.List;

public interface StockServiceI {
    StockDto addStock(StockDto stockDto);

    List<StockDto> getData();

    StockDto getQty(long itemID);
    List<StockDto> updateStock(List<GrnAddedDto> grnAddedDto);
    StockDto updateStockEdit(GrnAddedDto grnAddedDto);
}
