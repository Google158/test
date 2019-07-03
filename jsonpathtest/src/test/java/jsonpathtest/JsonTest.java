package jsonpathtest;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class JsonTest {
	public static void testJson3() {
		String jsonStr = "{ \"status\": 0, \"message\": \"成功\", \"data\": { \"opr_time\": \"20150612125212\", \"plan_remain\": [ { \"plan_name\": \"测试套餐\", \"plan_i_d\": \"000001\", \"resources_info\": [ { \"resources_code\": \"04\", \"sec_resources_info\": [ { \"sec_resources_name\": \"省内流量\", \"resources_left_info\": { \"total_res\": \"100\", \"used_res\": \"50\", \"remain_res\": \"50\", \"unit\": \"02\", \"valid_date\": \"20150611235959\" } }, { \"sec_resources_name\": \"数据流量\", \"resources_left_info\": { \"total_res\": \"100\", \"used_res\": \"40\", \"remain_res\": \"60\", \"unit\": \"02\", \"valid_date\": \"20150611235959\" } } ] }, { \"resources_code\": \"04\", \"sec_resources_info\": { \"sec_resources_name\": \"省内流量\", \"resources_left_info\": { \"total_res\": \"102400\", \"used_res\": \"88336\", \"remain_res\": \"14064\", \"unit\": \"03\", \"valid_date\": \"20150611235959\" } } } ] }, { \"plan_name\": \"测试套餐2\", \"plan_i_d\": \"0002\", \"resources_info\": { \"resources_code\": \"04\", \"sec_resources_info\": { \"sec_resources_name\": \"省内流量\", \"resources_left_info\": { \"total_res\": \"200\", \"used_res\": \"47\", \"remain_res\": \"153\", \"unit\": \"01\", \"valid_date\": \"20150611235959\" } } } }, { \"plan_name\": \"测试套餐3\", \"plan_i_d\": \"0003\", \"resources_info\": { \"resources_code\": \"04\", \"sec_resources_info\": { \"sec_resources_name\": \"省内流量\", \"resources_left_info\": { \"total_res\": \"2400\", \"used_res\": \"626\", \"remain_res\": \"1774\", \"unit\": \"01\", \"valid_date\": \"20150611235959\" } } } }, { \"plan_name\": \"测试套餐4\", \"plan_i_d\": \"00044\", \"resources_info\": [ { \"resources_code\": \"04\", \"is_multi_term\": \"0\", \"sec_resources_info\": { \"sec_resources_name\": \"数据流量\", \"resources_left_info\": { \"total_res\": \"30720\", \"used_res\": \"30720\", \"remain_res\": \"0\", \"unit\": \"03\", \"valid_date\": \"20150612143627\" } } }, { \"resources_code\": \"01\", \"is_multi_term\": \"1\", \"sec_resources_info\": { \"sec_resources_name\": \"语音\", \"resources_left_info\": { \"total_res\": \"150\", \"used_res\": \"37\", \"remain_res\": \"113\", \"unit\": \"01\", \"valid_date\": \"20150612143627\" } } } ] } ] } } ";
		JsonPath path = JsonPath.compile(
				"$.data.plan_remain..resources_info[?(@.resources_code == '04')].sec_resources_info..resources_left_info.remain_res");
		List<Object> resourceList = path.read(jsonStr);
		for (Object obj : resourceList) {
			if (obj instanceof String) {
				System.out.println(obj.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		testJson3();
	}
}
