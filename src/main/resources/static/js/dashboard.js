/**
 * Created by Eureka on 2016/5/20.
 */
$(document).ready(function () {
    $("#image-upload").on("change",{id: "#upload-image-form" , type: "image" }, upload);
    $("#video-upload").on("change",{id: "#upload-video-form" , type: "video" }, upload);
    $("#url-upload").on("change",{id: "#url-file" , type: "url" }, upload);
    $("#thumbnail-upload").on("change",{id: "#thumbnail-file" , type: "thumbnail" }, upload);
    get_resource("PICTURE",0);
    get_resource("AVATAR",0);
    get_post(0);
});
function upload(event) {
    var type = event.data.type;
    if ($(event.data.id)[0] == null) {
        return false;
    }
    $.ajax({
        url: "/dashboard/uploadFile",
        type: "POST",
        data: new FormData($(event.data.id)[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function (url) {
            console.log("File succesfully uploaded");
            console.log(url);
            if (type == "image")
                $('<img src="' + url + '" />').appendTo('#editor');
            else if (type == "video")
                $('<br/><blockquote class="video-container"><br/><video  controls="controls" src="' + url + '" /><br/></blockquote><br/>').appendTo('#editor');
            else if (type == "url")
                $("#url").val(url);
            else if (type == "thumbnail")
                $("#thumbnail").val(url);
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误 "+ error );
            $('#confirmModal').modal('toggle')
        }
    });
}

$("#add_post").click(function(e){
    $("#post_submit").unbind();
    $("#post_submit").on("click",create_post);
});
$("#add_resource").click(function(e){
    $("#resource_submit").unbind();
    $("#resource_submit").on("click",create_resource);
});

//    resource crud
function create_resource() {
    var url = '/resources';
    var type =  'POST';
    var  resource = {
        'name' : $('#name').val(),
        'url' : $('#url').val(),
        'content' : $('#description').val(),
        'type' : $('#resourceType').val()
    }
    console.log(resource);
    $.ajax({
        url: url,
        dataType: "json",
        type: type,
        data: resource,
        success: function (res) {
            console.log(res);
            $('#ResourceModal').modal('hide');
            $('#msg').html("创建资源 "+ resource.name + " 已成功");
            $('#confirmModal').modal('show');
            reset();
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#ResourceModal').modal('hide');
            $('#msg').html("出现了错误 "+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function get_resource(type, page) {
    //get 并且更新在dom里面
    $.ajax({
        url: "/resources",
        dataType: "json",
        type: "GET",
        data: {
            type: type,
            page: page
        },
        success: function (res) {
            console.log(res);
            var obj = res.content;

            var pre = res.number == 0 ? 0:res.number - 1;
            var next =  res.number == res.totalPages - 1 ? res.totalPages - 1:res.number + 1;
            var foo = '<nav class="page-nav"><ul class="pagination"><li><a onclick="get_resource(\'' + type+ '\','+ pre + ')" aria-label="Previous"><span aria-hidden="true">&laquo;</span> </a> </li>';
            for (var i = 1; i <= res.totalPages; i++ ){
                foo += '<li><a onclick="get_resource(\'' + type+ '\','+(i-1)+ ')">'+ i+ '</a></li>';
            };
            foo += '<li><a onclick="get_resource(\'' + type+ '\','+ next + ')" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li> </ul> </nav>';

            if (type == "AVATAR") {
                $("#avatars").html("");//清空info内容
                $.each(obj, function(i, item) {
                    if (item.url.split('/')[0] == "files") {
                        item.url = "files/thumbnails/" + item.url.split('/')[1]
                    }
                    $("#avatars").append(
                        '<div class="col-xs-6 col-sm-3 placeholder">'+
                        '<img src="'+item.url + '" onclick="update_resource('+ item.id +')" class="img-responsive avatar" alt="placeholder"/>' +
                        '<h4>'+item.name+'</h4>'+
                        '<span class="text-muted">'+item.content+'</span> ' + '<button class="del-btn" onclick="delete_resource('+ item.id +')">'+
                        '<svg style="width:24px;height:24px" viewBox="0 0 24 24">' +
                        '<path fill="#000000" d="M12,2C17.53,2 22,6.47 22,12C22,17.53 17.53,22 12,22C6.47,22 2,17.53 2,12C2,6.47 6.47,2 12,2M15.59,7L12,10.59L8.41,7L7,8.41L10.59,12L7,15.59L8.41,17L12,13.41L15.59,17L17,15.59L13.41,12L17,8.41L15.59,7Z" /> <' +
                        '/svg></button>'+
                        '</div>');
                });
                $(foo).appendTo("#avatars");
            } else if (type == "PICTURE") {
                $("#pictures").html("");//清空info内容
                $.each(obj, function(i, item) {
                    if (item.url.split('/')[0] == "files") {
                        item.url = "files/thumbnails/" + item.url.split('/')[1]
                    }
                    $("#pictures").append(
                        '<div class="col-xs-6 col-sm-3 placeholder">'+
                        '<img src="'+item.url + '" onclick="update_resource('+ item.id +')" class="img-responsive picture" alt="placeholder"/>' +
                        '<h4>'+item.name+'</h4>'+
                        '<span class="text-muted">'+item.content+'</span> ' + '<button class="del-btn" onclick="delete_resource('+ item.id +')">'+
                        '<svg style="width:24px;height:24px" viewBox="0 0 24 24">' +
                        '<path fill="#000000" d="M12,2C17.53,2 22,6.47 22,12C22,17.53 17.53,22 12,22C6.47,22 2,17.53 2,12C2,6.47 6.47,2 12,2M15.59,7L12,10.59L8.41,7L7,8.41L10.59,12L7,15.59L8.41,17L12,13.41L15.59,17L17,15.59L13.41,12L17,8.41L15.59,7Z" /> <' +
                        '/svg></button>'+
                        '</div>');
                });
                $(foo).appendTo("#pictures");
            }
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误 "+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function update_resource(id) {
    $.ajax({
        url: "/resources/"+id,
        type: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);
            $('#name').val(res.name);
            $('#url').val(res.url);
            $('#description').val(res.content);
            $('#resourceType').val(res.resourceType);
            $('#ResourceModal').modal('show');
            $("#resource_submit").unbind();
            $("#resource_submit").bind("click",{ id: id },update_res_req);
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误"+ error.toString() );
            $('#confirmModal').modal('show')
        }
    });
}
function update_res_req(event){
    var id = event.data.id;
    var  resource = {
        'name' : $('#name').val(),
        'url' : $('#url').val(),
        'content' : $('#description').val(),
        'type' : $('#resourceType').val()
    }
    console.log(resource);
    $.ajax({
        url: "/resources/"+ id,
        dataType: "json",
        type: "PUT",
        data: resource,
        success: function (res) {
            console.log(res);
            $('#ResourceModal').modal('hide');
            $('#msg').html("更新资源 "+ res.id + " 已成功");
            $('#confirmModal').modal('show');
            reset();
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#ResourceModal').modal('hide');
            $('#msg').html("出现了错误"+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function delete_resource(id){
    console.log("deleting "+ id);
    $.ajax({
        url: "/resources/"+ id,
        type: "DELETE",
        success: function (res) {
            console.log(res);
            $('#msg').html("删除资源"+ res.id + "已成功");
            $('#confirmModal').modal('show');
            reset();
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误"+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}

//    post crud
function create_post() {
    var url = '/posts';
    var type =  'POST';
    var  post = {
        'title' : $('#title').val(),
        'thumbnail' : $('#thumbnail').val(),
        'outline' : $('#outline').val(),
        'content' : $('#editor').html(),
        'type' : $('#postType').val()
    };
    console.log(post);
    $.ajax({
        url: url,
        dataType: "json",
        type: type,
        data: post,
        success: function (res) {
            console.log(res);
            $('#PostModal').modal('toggle');
            $('#msg').html("创建帖子 "+ post.title + " 已成功");
            $('#confirmModal').modal('toggle');
            reset();
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#PostModal').modal('toggle');
            $('#msg').html("出现了错误 "+ error.status );
            $('#confirmModal').modal('toggle')
        }
    });
}
function get_post(page) {
    $.ajax({
        url: "/posts",
        dataType: "json",
        type: "GET",
        data: {
            page: page
        },
        success: function (res) {
            console.log(res);
            var obj = res.content;
            $("#posts").html("");
            $.each(obj, function(i, item) {
                $("#posts").append(
                    '<tr>'+
                    '<th>'+ item.id + '</th>' +
                    '<th>'+ item.title + '</th>' +
                    '<th>'+ item.postType + '</th>' +
                    '<th>'+ item.thumbnail + '</th>' +
                    '<th>'+ item.outline + '</th>' +
                    '<th>'+ moment(item.createdAt).format("YYYY-MM-DD HH:mm:ss") + '</th>' +
                    '<th class="buttons">' +
                    '<button class="modify" onclick="update_post('+item.id+')">' +
                    '<span class="glyphicon glyphicon-edit" ></span>' +
                    '</button>' +
                    '<button class="delete" onclick="del_post_modal('+item.id+')"> ' +
                    '<span class="glyphicon glyphicon-remove" ></span>' +
                    '</button>' +
                    '<button class="delete" onclick="copy_post('+item.id+')"> ' +
                    '<span class="glyphicon glyphicon-copy" ></span>' +
                    '</button>' +
                    '</th>' +
                    '</tr>');
            });
            var pre = res.number == 0 ? 0:res.number - 1;
            var next =  res.number == res.totalPages - 1 ? res.totalPages - 1:res.number + 1;
            var foo = '<nav class="page-nav"><ul class="pagination"><li><a onclick="get_post(' + pre + ')" aria-label="Previous"><span aria-hidden="true">&laquo;</span> </a> </li>';
            for (var i = 1; i <= res.totalPages; i++ ){
                foo += '<li><a onclick="get_post('+ (i-1) + ')">'+ i+ '</a></li>';
            };
            foo += '<li><a onclick="get_post('+ next + ')" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li> </ul> </nav>';
            $("#post_pages").html(foo);
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误 "+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function del_post_modal(id){
    $('#delete_msg').html("确认要删除帖子 "+ id + " ？");
    $("#delete_post_btn").unbind();
    $("#delete_post_btn").bind("click",{id : id},delete_post);
    $('#deleteModal').modal('show');
}
function delete_post(event){
    var id =  event.data.id;
    console.log("deleting "+ id);
    $.ajax({
        url: "/posts/"+ id,
        type: "DELETE",
        success: function (res) {
            console.log(res);
            $('#msg').html("删除帖子"+ res.id + "已成功");
            $('#confirmModal').modal('show');
            reset();
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误"+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function update_post(id) {
    $.ajax({
        url: "/posts/"+id,
        type: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);
            $('#title').val(res.title);
            $('#outline').val(res.outline);
            $('#thumbnail').val(res.thumbnail);
            $('#editor').html(res.content);
            $('#postType').val(res.postType);
            $('#PostModal').modal('show');
            $("#post_submit").unbind();
            $("#post_submit").bind("click",{ id: id },update_post_req);
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误"+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function copy_post(id) {
    $.ajax({
        url: "/posts/"+id,
        type: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);
            $('#title').val(res.title);
            $('#outline').val(res.outline);
            $('#thumbnail').val(res.thumbnail);
            $('#editor').html(res.content);
            $('#postType').val(res.postType);
            $('#PostModal').modal('show');
            $("#post_submit").unbind();
            $("#post_submit").bind("click",{ id: id },create_post);
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#msg').html("出现了错误"+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}
function update_post_req(event){
    var id = event.data.id;
    var  post = {
        'title' : $('#title').val(),
        'thumbnail' : $('#thumbnail').val(),
        'outline' : $('#outline').val(),
        'content' : $('#editor').html(),
        'type' : $('#postType').val()
    };
    console.log(post);
    $.ajax({
        url: "/posts/"+ id,
        dataType: "json",
        type: "PUT",
        data: post,
        success: function (res) {
            console.log(res);
            $('#PostModal').modal('hide');
            $('#msg').html("更新资源 "+ res.id + " 已成功");
            $('#confirmModal').modal('show');
            reset();
        },
        error: function (error) {
            // Handle upload error
            console.log(error);
            $('#PostModal').modal('hide');
            $('#msg').html("出现了错误"+ error.status );
            $('#confirmModal').modal('show')
        }
    });
}

function reset() {
    $('#name').val("");
    $('#title').val("");
    $('#description').val("");
    $('#thumbnail').val("");
    $('#outline').val("");
    $('#url').val("");
    $('#editor').html("");
    $('#postType').val("MAIN");
    $('#resourceType').val("AVATAR")
}

$(function () {
    function initToolbarBootstrapBindings() {
        var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                'Times New Roman', 'Verdana'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');

        $.each(fonts, function (idx, fontName) {
            fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
        });

        $('a[title]').tooltip({container: 'body'});

        $('.dropdown-menu input').click(function () {
            return false;
        })
            .change(function () {
                $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
            }).keydown('esc', function () {
            this.value = '';
            $(this).change();
        });

        $('[data-role=magic-overlay]').each(function () {
            var overlay = $(this), target = $(overlay.data('target'));
            overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
        });

        if ("onwebkitspeechchange" in document.createElement("input")) {
            var editorOffset = $('#editor').offset();
            //$('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
        }

        else {
            $('#voiceBtn').hide();
        }
    };

    function showErrorAlert(reason, detail) {
        var msg = '';
        if (reason === 'unsupported-file-type') {
            msg = "Unsupported format " + detail;
        }
        else {
            console.log("error uploading file", reason, detail);
        }

        $('<div class="alert"> <button type="button" class="close" data-dismiss="alert"></button>' +
            '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
    };

    initToolbarBootstrapBindings();

    $('#editor').wysiwyg({fileUploadError: showErrorAlert});

    window.prettyPrint;
});
