package online.zhaopei.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import online.zhaopei.myproject.constant.DeliveryHeadConstant;
import online.zhaopei.myproject.domain.ecssent.DeliveryHead;
import online.zhaopei.myproject.domain.ecssent.DeliveryList;
import online.zhaopei.myproject.service.ecssent.DeliveryHeadService;
import online.zhaopei.myproject.service.ecssent.DeliveryListService;

@Controller
@RequestMapping("/deliveries")
public class DeliveriesController extends BaseController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8610022445562209367L;

	@Autowired
	private DeliveryHeadService deliveryHeadService;
	
	@Autowired
	private DeliveryListService deliveryListService;
	
	@GetMapping("/{headGuid}/deliveryLists")
	@ResponseBody
	public List<DeliveryList> index(@PathVariable("headGuid") String headGuid) {
		List<DeliveryList> deliveryListList = this.deliveryListService.getDeliveryListByGuid(headGuid);
		return deliveryListList;
	}
	
	@GetMapping
	public ModelAndView index(DeliveryHead deliveryHead) {
		PageInfo<DeliveryHead> pageInfo = this.getPageInfo(deliveryHead, DeliveryHead.class, this.deliveryHeadService, "getDeliveryHeadList");
		ModelAndView mv = this.buildBaseModelAndView("deliveries/list", pageInfo);
		mv.addObject("deliveryHead", deliveryHead);
		mv.addObject("deliveryHeadList", pageInfo.getList());
		mv.addObject("appStatus", DeliveryHeadConstant.getAPP_STATUS_MAP());
		return mv;
	}
}
