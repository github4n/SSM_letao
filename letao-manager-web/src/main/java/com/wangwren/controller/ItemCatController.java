package com.wangwren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangwren.common.pojo.EasyUIDataTree;
import com.wangwren.service.ItemCatService;

/**
 * 商品类目controller
 * @author wwr
 *
 */
@Controller
public class ItemCatController {

	/**
	 * 记得加上服务消费
	 */
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 根据父节点查询类目
	 * 
	 * 该url在js文件夹中common.js中，// 初始化选择类目组件 initItemCat : function(data){ 中
	 * 
	 * 由于使用easyUI的tree组件，在每次点开一个tree结点时，就会根据这个结点的id去查询其下的子节点，即会有参数传来
	 * 如果是第一次访问，即将参数设为默认值0，即查询所有父节点
	 * 
	 * @RequestParam(name="id",defaultValue="0")记得加上默认值，否则第一次访问没有数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUIDataTree> getAllItemCat(@RequestParam(name="id",defaultValue="0")Long parentId) throws Exception{
		
		List<EasyUIDataTree> dataTrees = itemCatService.getAllItemCat(parentId);
		
		return dataTrees;
	}
} 
