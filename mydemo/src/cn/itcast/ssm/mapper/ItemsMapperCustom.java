package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;


public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//批量删除商品信息
	public void deleteItemsByLists(Integer[] items_id)throws Exception;
	
	//添加商品
	public void insertItems(ItemsCustom itemsCustom) throws Exception;



}