package com.ecps.service.impl;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.util.ECPSJsonUtil;
import com.ecps.common.util.GeneratorIDUtil;
import com.ecps.mapper.TbItemDescMapper;
import com.ecps.mapper.TbItemParamItemMapper;
import com.ecps.model.TbItem;
import com.ecps.model.TbItemDesc;
import com.ecps.model.TbItemParamItem;
import com.ecps.service.ItemService;
import com.ecps.service.base.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品管理ServiceImpl
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-27 上午 09:40
 */
@Service
public class ItemServiceImpl extends BaseServiceImpl<TbItem> implements ItemService {

    @Autowired
    private TbItemDescMapper descMapper;

    @Autowired
    private TbItemParamItemMapper paramMapper;

    @Override
    public ECPSResult createItem(TbItem item, String desc, String itemParams) {
        long itemId = GeneratorIDUtil.genItemId();

        item.setId(itemId);
        item.setStatus((byte) 1);
        // 保存商品基本信息， 调用baseService中的保存方法
        super.save(item);

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getCreated());
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);

        descMapper.insert(itemDesc);

        TbItemParamItem paramItem = new TbItemParamItem();
        paramItem.setCreated(item.getCreated());
        paramItem.setUpdated(item.getCreated());
        paramItem.setItemId(itemId);
        paramItem.setParamData(itemParams);

        paramMapper.insert(paramItem);

        return ECPSResult.success();
    }

    @Override
    public String getItemParamHTML(Long itemId) {
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        List<TbItemParamItem>  paramItems = paramMapper.select(itemParamItem);
        if (CollectionUtils.isEmpty(paramItems)){
            return  null;
        }
        TbItemParamItem paramItem = paramItems.get(0);
        String paramData = paramItem.getParamData();

        List<Map> mapList = ECPSJsonUtil.jsonToList(paramData, Map.class);

        StringBuffer buffer = new StringBuffer();

        buffer.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        buffer.append("	<tbody>\n");
        for (Map<String, Map<String, String>> map : mapList) {
            buffer.append("		<tr>\n");
            buffer.append("			<th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
            List<Map<String, Map<String, String>>> list2= (List<Map<String, Map<String, String>>>) map.get("params");
            for (Map map2 : list2) {
                buffer.append("		<tr>\n");
                buffer.append("			<td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
                buffer.append("			<td>"+map2.get("v")+"</td>\n");
                buffer.append("		</tr>\n");
            }
        }
        buffer.append("	</tbody>\n");
        buffer.append("</table>");

        return buffer.toString();
    }


}
