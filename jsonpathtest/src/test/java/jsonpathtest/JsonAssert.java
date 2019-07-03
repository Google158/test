package jsonpathtest;

import com.jayway.jsonpath.JsonPath;

public class JsonAssert {

	public static void main(String[] args) {
		String json = "{\"code\":200,\"data\":{\"roleList\":[{\"roleCode\":\"administrator\",\"roleName\":\"系统管理员\",\"roleType\":0,\"userId\":1},{\"roleCode\":\"ChengjiaSignetAdmin\",\"roleName\":\"印章管理员（诚加）\",\"roleType\":0,\"userId\":1},{\"roleCode\":\"SignetAdmin-CX\",\"roleName\":\"印章管理员(创喜)\",\"roleType\":0,\"userId\":1},{\"roleCode\":\"SignetAdmin-XM\",\"roleName\":\"印章管理员(项目)\",\"roleType\":0,\"userId\":1}],\"siDeptBean\":{\"code\":\"08\",\"corptionid\":\"MORG2017051178\",\"createdate\":\"2017-05-23 00:00:00\",\"depttype\":\"0\",\"enablestate\":\"2\",\"id\":44981,\"ishrcancel\":\"N\",\"mdmCode\":\"MAGDEPT201705007580\",\"mdmCreatedon\":\"2017-05-23 15:44:15\",\"mdmPk\":\"0001H210000000B12SC6\",\"mdmSeal\":0,\"name\":\"信息管理中心\",\"pkDepartmentid\":\"1001H2100000026M3E5F\",\"pkPsndoc\":\"PD160701000498\",\"ts\":\"2018-03-24 10:00:44\"},\"siOrgBean\":{\"code\":\"3012405\",\"constructiontime\":\"2014-12-02 10:17:35\",\"fatherorgnization\":\"0001H2100000000023XT\",\"id\":97,\"mdmCode\":\"MORG2015070819\",\"mdmCreatedon\":\"2014-12-02 10:17:35\",\"mdmPk\":\"0001H21000000000NUJ7\",\"mdmSeal\":0,\"name\":\"荔城物业服务分公司（豪园）\",\"organizationid\":\"0001H2100000000024FN\",\"principal\":\"PD150706019317\",\"shortname\":\"荔城物业服务分公司（豪园）\",\"ts\":\"2018-09-14 23:10:10\"},\"siUserBean\":{\"belongAreaOrg\":\"\",\"code\":\"admin\",\"enablestate\":\"Y\",\"id\":1,\"isgeneratead\":\"Y\",\"isturnover\":\"N\",\"leavedate\":\"2016-05-05 00:00:00\",\"mdmCode\":\"US111111111111\",\"mdmCreatedon\":\"2014-12-07 22:02:55\",\"mdmPk\":\"0001H210000000007ADG\",\"mdmSeal\":0,\"mobile\":\"13711663537\",\"name\":\"系统管理员\",\"passwd\":\"8a6ecc606878daeef7570a8b4fd26740\",\"pkDept\":\"MAGDEPT201705007580\",\"pkOrg\":\"MORG2015070819\",\"pkPsndoc\":\"PD150710095238\",\"pkUsertype\":\"1001H9100000003N3E77\",\"postname\":\"三级环境管理员\",\"siteno\":\"2014021017\",\"ts\":\"2016-12-02 08:57:02\"},\"userId\":1,\"userName\":\"系统管理员\"},\"success\":true}";
		String expression = "$.data.roleList[0].roleCode";
		String expression1 = "$.success";
		String expression2 = "$.success";
		String expression3 = "$.data.siUserBean.name";
		JsonAssert jsonAssert = new JsonAssert();
		System.out.println(jsonAssert.jsonPath(json, expression));
		System.out.println(jsonAssert.jsonPath(json, expression1));
		System.out.println(jsonAssert.jsonPath(json, expression3));

	}

	public String jsonPath(String json, String expression) {
		String getValue = JsonPath.read(json, expression).toString();

		if (getValue.contains("[")) {
			getValue = getValue.substring(getValue.indexOf("[") + 1, getValue.length() - 1);
		}
		return getValue.replaceAll("\"", "");
	}
}