/**
 * 파일업로드
 */
$(function(){
	$("input[type='file']").change(function(){
		
		//첨부 파일 가져오기
		var files=$("input[name='uploadFile']")[0].files;
		console.log(files);
		
		//첨부파일을 formData 로 만들어 전송
		var formData = new FormData();
		for(var i=0;i<files.length;i++){
			formData.append("uploadFile",files[i]);
		}		
		
		// enctype="multipart/form-data" => processData:false,contentType:false,
		
		$.ajax({
			url:'/uploadAjax', //도착지
			type:'post',
			processData:false,
			contentType:false,
			data:formData,
			success:function(result){
				console.log(result);
				showUploadedFile(result);
			},
			error:function(xhr,status,error){
				console.log("에러");
			}
		})
	})//uploadBtn 종료
	
	function showUploadedFile(uploadResultArr){
		var str = "";
		var uploadResult = $(".uploadResult ul");
		
		$(uploadResultArr).each(function(i,obj){
			if(obj.fileType){ //image
				// 썸네일 이미지 경로 링크				
				// 2021\\06\\17\\s_2a7f8a81-525e-4781-a814-970096f42b45_2.png
				var fileCallPath = encodeURIComponent(obj.uploadPath+"\\s_"+obj.uuid+"_"+obj.fileName);
			
				// 원본 이미지 경로
				var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g),"/");
			
				str+="<li><a href=\"javascript:showImage(\'"+originPath+"\')\">";
				str+="<img src='/display?fileName="+fileCallPath+"'>"+obj.fileName+"</a>";
				str+="<button type='button' class='btn btn-warning btn-circle btn-sm'><i class='fa fa-times'></i></button>";			
				str+="</li>";
			}else{
				var fileCallPath = encodeURIComponent(obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName);
				str+="<li><a href='/download?fileName="+fileCallPath+"'>";
				str+="<img src='/resources/img/attach.png'>"+obj.fileName+"</a>";
				str+="<button type='button' class='btn btn-warning btn-circle btn-sm'><i class='fa fa-times'></i></button>";
				str+="</li>";				
			}
		})		
		uploadResult.append(str);
	}	
})
