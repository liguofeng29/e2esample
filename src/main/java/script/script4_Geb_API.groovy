/**
 * Geb API
 *
 * http://www.gebish.org/manual/
 */
import geb.Browser

def testPage = new File('src/main/java/html/script4.html')

Browser.drive {
	// 指定URLでブラウザオープン
    go testPage.toURI().toString()

	/**************/
	/** for form **/
	/**************/
	// direct
	$('input', name: 'username1').value("ユーザ１")
	$('input', name: 'password1').value("パスワード１")

	// use shortcuts
	def form = $('#form1')
	form.username2 = "ユーザ２"
	form.password2 = "パスワード２"

	// use with
	$('#form1').with {
		username3 = 'ユーザ３'
		password3 = 'パスワード３'
	}

    // get value
	println ($('input', name: 'username1').value())
	println ($('#form1').password1)

	/******************/
	/** for checkbox **/
	/******************/
	// click and set value
	$('input', name: 'checkbox1').click()
	$('checkbox', name: 'checkbox1').value(true) // or false

	// click and set value with shortcut
	$('#form2').checkbox2().click()
	$('#form2').checkbox2().value(false) 		 // or true

	// get value
	println ($('input', name: 'checkbox1').value())
	println ($('#form2').checkbox2().value())


	/************************/
	/** for multi-checkbox **/
	/************************/
	$('#form3').multicheck = true // check all
	println ($('#form3').multicheck) // [multi-check1, multi-check2, multi-check3]

	/************************/
	/** for radio          **/
	/************************/
	$('#form4').sex = "female" // set
	println ($('#form4').sex)  // get female
	assert $('#form4').sex == 'female' // assert

	/************************/
	/** for input file     **/
	/************************/
	// need to set absolute path
	$('#form5').csvFile = new File("src/main/java/csv/data.csv").getAbsolutePath()
	// Or
	// $('input', name : 'csvFile').value('../csv/data.csv')

	/*************************/
	/** for drop-down select**/
	/*************************/
	$('select', name: 'optionlist1').value('2') // Or 'option2'

	// use shortcut
	$('#form6').optionlist2 = 'option3'
	// $('#form6').optionlist = 3

	// get value
	println ($('#form6').optionlist1) // print 2

	// assert
	assert $('#form6').optionlist2 == '3'

	sleep 10 * 1000

}.quit()

