package com.qnbc.venueReservation.controller;
//收藏Controller
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.utils.PageUtils;
import com.qnbc.venueReservation.domain.Collect;
import com.qnbc.venueReservation.entity.Recommend;
import com.qnbc.venueReservation.service.ICollectService;
import com.qnbc.venueReservation.utils.MPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/venueReservation/collect")
public class CollectController {

    @Autowired
    private ICollectService collectService;
    //
    //@Autowired
    //private IProductService productService;
    //
    //@Autowired
    //private WeixinpayProperties weixinpayProperties;

    //推荐数量
    public static int cfCount = 5;


    @RequestMapping("/del")
    @Transactional
    public AjaxResult list(Integer id) {

        collectService.removeById(id);

        return AjaxResult.success();
    }

    //创建订单 返回订单号
    @GetMapping("/create")
    @Transactional
    public AjaxResult create(Integer id) {
        LambdaQueryWrapper<Collect> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Collect::getUserid, "1");
        queryWrapper.eq(Collect::getProductid, id);
        Collect one = collectService.getOne(queryWrapper);
        if (null != one) {
            collectService.removeById(one);
            return AjaxResult.success("已取消");
        }

        Collect collect = new Collect();
        collect.setUserid("1");
        collect.setProductid(Long.valueOf(id));
        collectService.save(collect);
        return AjaxResult.success("收藏成功");
    }

//
//	/**
//	 * 查询某个用户的推荐歌曲列表
//	 */
//	@RequestMapping(value = "/topRecommendOfUserId", method = RequestMethod.GET)
//	public Object topRecommendOfUserId(@RequestParam Map<String, Object> params, JiankangzixunEntity jiankangzixun, HttpServletRequest request) {
//		String uId = String.valueOf(request.getSession().getAttribute("userId"));
//		System.out.println("当前用户：" + uId);
//		String userId = "1";//用户id
//		if (null != uId) {
//			userId = uId;
//		}
//		if (!Objects.equals(userId, "1")) {
//			EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
//			ew.allEq(MPUtil.allEQMapPre(new StoreupEntity<>(), "storeup"));
//			List<StoreupView> list = storeupService.selectListView(ew);
//			//List<Collect> list = new ArrayList<>();
//			List<Recommend> allRecommend = new ArrayList<Recommend>();
//			List<Long> cfItemIds = new ArrayList<Long>();
//			for (StoreupEntity col : list) {
//				Recommend r = new Recommend();
//				r.setUserId(col.getUserid());
//				r.setSongId(col.getRefid());
//				r.setCommend(1);
//				allRecommend.add(r);
//			}
//			DataModel dataModel = getDadaModel(allRecommend);
//			cfItemIds = baseItem(Integer.valueOf(userId), dataModel);
//			if (cfItemIds != null) {
//				List<JiankangzixunEntity> ls = new ArrayList<JiankangzixunEntity>();
//				for (Long l : cfItemIds) {
//					JiankangzixunEntity s = jiankangzixunService.selectById(l.intValue());
//					//System.out.println("歌曲id："+l);
//					ls.add(s);
//				}
//				Map<String, Object> resultMap = new HashMap<>();
//
//				EntityWrapper<JiankangzixunEntity> ew1 = new EntityWrapper<JiankangzixunEntity>();
//				PageUtils page = jiankangzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew1, jiankangzixun), params), params));
//				page.setList(ls);
//				resultMap.put("data", page);
//				return R.ok(resultMap);
//			}
//		}
//		return R.ok();
//	}
//
//	/**
//	 * 根据数据库表数据，得到用户-音乐收藏分数矩阵
//	 *
//	 * @param allRecommend
//	 * @return
//	 */
//	public DataModel getDadaModel(List<Recommend> allRecommend) {
//		System.out.println("数据库表的数据总数： " + allRecommend.size());
//		if (allRecommend.size() > 0) {
//			Map<Long, List<Preference>> map = new HashMap<Long, List<Preference>>();
//			for (Recommend rItem : allRecommend) {
//				List<Preference> preferenceList = new ArrayList<Preference>();
//				Long userId = rItem.getUserId();
//				Long songId = rItem.getSongId();
//				Integer commend = rItem.getCommend();
//				Integer preference = 0;
//				if (commend != 0) {
//					preference = commend;
//					preferenceList.add(new GenericPreference(userId, songId, preference));
//					if (map.containsKey(userId)) {
//						List<Preference> preferenceListTemp = map.get(userId);
//						preferenceListTemp.addAll(preferenceList);
//						map.put(userId, preferenceListTemp);
//					} else {
//						map.put(userId, preferenceList);
//					}
//				}
//			}
//
//			FastByIDMap<PreferenceArray> preferences = new FastByIDMap<PreferenceArray>();
//			Set<Long> set = map.keySet();
//			for (Long i : set) {
//				List<Preference> preList = map.get(i);
//				preferences.put(i, new GenericUserPreferenceArray(preList));
//			}
//			DataModel model = new GenericDataModel(preferences);
//			return model;
//
//		} else {
//			System.out.println("******数据库中没有任何音乐收藏记录！******");
//			return null;
//		}
//	}
//
//	/**
//	 * 基于音乐的协同过滤推荐
//	 *
//	 * @param userId
//	 * @param model
//	 * @return
//	 */
//	public List<Long> baseItem(Integer userId, DataModel model) {
//		if (model == null) {
//			return null;
//		}
//		try {
//			ItemSimilarity similarity = new UncenteredCosineSimilarity(model);
//			LongPrimitiveIterator iterator = model.getItemIDs();
//			long idTemp = iterator.next();
//			while (iterator.hasNext()) {
//				long id = iterator.next();
//				double sim = similarity.itemSimilarity(idTemp, id);
//			}
//			Recommender recommender = new GenericItemBasedRecommender(model, similarity);
//			List<RecommendedItem> items = recommender.recommend(userId, cfCount);
//			List<Long> cfItemIds = new ArrayList<Long>();
//			System.out.println("推荐商品id集合：");
//			for (RecommendedItem ri : items) {
//				Long itemid = ri.getItemID();
//				cfItemIds.add(itemid);
//			}
//			System.out.println(cfItemIds);
//			return cfItemIds;
//		} catch (TasteException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
