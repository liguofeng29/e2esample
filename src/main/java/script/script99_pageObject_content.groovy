/**
 * Page Content
 *
 * 引数
 * required : default true
 *            要素が存在しない場合、RequiredPageContentNotPresent例外を投げるかどうか
 *
 * cache : defalut false -
 * to    : defalut null -
 * wait  : defalut false -
 * page  : defalut null

 */
import geb.Browser

Browser.drive {
	// baseUrl
	config.baseUrl = "http://www.gebish.org/"
	to ExamplePage1

	sleep 3 * 1000 // for debug





}.quit()


