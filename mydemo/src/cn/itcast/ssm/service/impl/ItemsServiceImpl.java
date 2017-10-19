package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	} 

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
        Items items = itemsMapper.selectByPrimaryKey(id);
		
		//返回ItemsCustom
		ItemsCustom itemsCustom = new ItemsCustom();
		if (items != null) {
			//将items中属性值拷贝到itemsCustom
			BeanUtils.copyProperties(items, itemsCustom);
			return itemsCustom;
		} else {
			return null;
		}
		
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// 添加业务校验，通常在service接口对关键数据进行校验
		
		//更新商品信息,使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括大文本
		//要求必须传入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		 
		
	}

	@Override
	public void deleteItemsByLists(Integer[] items_id) throws Exception {
		// 批量删除商品信息
		itemsMapperCustom.deleteItemsByLists(items_id);
		
	}

	@Override
	public void insertItems(ItemsCustom itemsCustom) throws Exception {
		// 添加商品
		itemsMapperCustom.insertItems(itemsCustom);

	}

	

}
