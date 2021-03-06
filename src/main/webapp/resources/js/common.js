// form 공백체크 - 전문현 추가
function form_chk(frm, out_obj)
{
	var sChk = "N";
	var f_obj = "";
	out_obj = out_obj.replace(/ /g, '');
	var out_arr = out_obj.split(",");
	for (var i = 0; i < frm.length; i++)
	{
		sChk = "N";
		if (frm[i].type == "text" || frm[i].type == "password" || frm[i].type == "select-one" || frm[i].type == "textarea")
		{
			if (out_obj != "")
			{
				for (var j = 0; j < out_arr.length; j++)
				{
					if (frm[i].id == out_arr[j] || frm[i].name == out_arr[j])
					{
						sChk = "Y";
						break;
					}
				}	
			}
			
			if (sChk == "Y")
			{
				continue;
			}
			
			f_obj = frm[i].value.replace(/ /g, '');
			if (f_obj.length == 0)
			{
				//alert(frm[i].type + "//" + frm[i].name);
				frm[i].value = "";
				if (frm[i].type == "select-one")
				{
					alert(frm[i].title + "을(를) 선택하세요!");
				}
				else
				{
					alert(frm[i].title + "을(를) 입력하세요!");
				}
				frm[i].focus();
				return false;
			}
		}
	}
	return true;
}

// html tag 제거 - 전문현 추가
function remove_html(text)
{
	var return_text = text;
	
	if (return_text.length > 0)
	{
		var pattern = /<[^>]+>/g;
		return_text = return_text.replace(pattern, "");
	}
	
	return return_text;
}

// 비밀번호 안전도 체크
password_check = function(obj_) {
		 
    var score = 0;

    var password = $(obj_).val();
    
    var sChk = "N";

    score += password.length * 4;

    if (/^([\d\W]+|[a-zA-Z]+|)([\W\d]+[a-zA-Z]+|[a-zA-Z]+[\W\d]+)+$/.test(password)) {
      //password has 3 numbers
      if (password.match(/(.*[0-9].*[0-9].*[0-9])/)) { score += 10; }

      //password has 2 symbols
      if (password.match(/(.*[!,@,#,$,%,^,&,*,?,_,~].*[!,@,#,$,%,^,&,*,?,_,~])/)) { score += 5; }

      //password has Upper and Lower chars
      if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) { score += 20; }

      //password has number and chars
      if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) { score += 15; }
      //
      //password has number and symbol
      if (password.match(/([!,@,#,$,%,^,&,*,?,_,~])/) && password.match(/([0-9])/)) { score += 15; }

      //password has char and symbol
      if (password.match(/([!,@,#,$,%,^,&,*,?,_,~])/) && password.match(/([a-zA-Z])/)) { score += 15; }

      //password is just a numbers or chars
      if (password.match(/^\w+$/) || password.match(/^\d+$/)) { score -= 10; }
    } else {
      score = 0;
    }

    if (score >= 40)
    {
    	sChk = "Y";
    }
    
    return sChk;
}


// 달의 마지막 일자
function Last_Day(objDate) {

	var arrDate = objDate.split("-");

	lastDate = new Date(arrDate[0], arrDate[1], 0);
      
	return lastDate.getDate();

}


// 이메일 체크
function Check_Mail(str)
{
    emailEx = /[^@]+@[A-Za-z0-9_-]+.[A-Za-z0-9_-]+.[A-Za-z0-9_-]+.[A-Za-z]+/;
    if (emailEx.test(str))
    {
    	return true;
    }
	return false;
}  


function FormatNumber(strValue) {

	if(!isNaN(strValue))
	{
		strValueS = strValue.toString();
		var len = strValueS.length;
		var strValueN = "";
		for(var i=len;i>0;i--)
		{
			if(i!=len && i%3 == len%3)
			{
				strValueN = ","+strValueN;
				strValueN = strValueS.substring(i,i-1).concat(strValueN);
			}
			else {
				strValueN = strValueS.substring(i,i-1).concat(strValueN);
			}
		}
		return strValueN
	}
	else {
		return strValue
	}
}