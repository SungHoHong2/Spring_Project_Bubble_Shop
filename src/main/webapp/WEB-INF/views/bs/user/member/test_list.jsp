<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	$(document).ready(function(){
		document.title = "전문현 테스트 페이지";
	});

</script>
<form id="frm" name="frm" method="post" enctype="multipart/form-data">
	<table border="1" cellspacing="1" cellpadding="1" >
		<tr>
			<td>제목 1 : <input type="text" id="title0" name="list[0].title" value="ere" /></td>
			<td>제목 2 : <input type="text" id="title1" name="list[1].title" value="dsagfdsaf" /></td>
			<td>제목 3 : <input type="text" id="title2" name="list[2].title" value="llmjwekw" /></td>
			<td>제목 4 : <input type="text" id="title3" name="list[3].title" value="yhnmju" /></td>
			<td>제목 5 : <input type="text" id="title4" name="list[4].title" value="qazxsw" /></td>
		</tr>
		
		<tr>
			<td>내용 1 : <input type="text" id="content0" name="list[0].content" value="96" /></td>
			<td>내용 2 : <input type="text" id="content1" name="list[1].content" value="qscfgh" /></td>
			<td>내용 3 : <input type="text" id="content2" name="list[2].content" value="pluybn" /></td>
			<td>내용 4 : <input type="text" id="content3" name="list[3].content" value="tgbnhjklp" /></td>
			<td>내용 5 : <input type="text" id="content4" name="list[4].content" value="cvbnmlpoiu" /></td>
		</tr>
		
		<tr>
			<td colspan="5"><input type="file" id="upfile0" name="list[0].upfile"></td>
		</tr>
		<tr>
			<td colspan="5"><input type="file" id="upfile1" name="list[1].upfile"></td>
		</tr>
		<tr>
			<td colspan="5"><input type="file" id="upfile2" name="list[2].upfile"></td>
		</tr>
		<tr>
			<td colspan="5"><input type="file" id="upfile3" name="list[3].upfile"></td>
		</tr>
		<tr>
			<td colspan="5"><input type="file" id="upfile4" name="list[4].upfile"></td>
		</tr>
		
	</table>
	<br /><br />
	<input type="submit" value="전송" />
</form>
<br />
