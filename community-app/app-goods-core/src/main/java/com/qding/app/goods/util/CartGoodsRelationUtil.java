package com.qding.app.goods.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qding.app.goods.model.CartGoodsRelation;

public class CartGoodsRelationUtil {

	public static List<CartGoodsRelation> convertString2CartGoodsRelation(String cartGoodsRelation) {
		List<CartGoodsRelation> cartGoodsRelations = new ArrayList();
		if (StringUtils.isBlank(cartGoodsRelation)) {

		} else {
			Gson gson = new GsonBuilder().create();
			cartGoodsRelations = (List) gson.fromJson(cartGoodsRelation, new TypeToken<List<CartGoodsRelation>>() {
			}.getType());
		}

		;
		return cartGoodsRelations;
	}
}
