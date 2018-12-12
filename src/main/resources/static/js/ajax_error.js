$.ajax({
    url: '/err/ajaxError',
    type: 'POST',
    async: true,
    success: function (data) {
        if (data.code === 200) {
            alert('success');
        } else {
            alert('fail: ' + data.msg);
        }
    },
    error: function (){
        alert('error');
    }
});