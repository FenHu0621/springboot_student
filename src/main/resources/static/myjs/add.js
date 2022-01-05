var vm = new Vue({
    el:'#add',
    data:{
        mList:[],
        cList:[],
        gList:[],
        student:{},
        imgaddress:''
    },
    methods:{
        init:function () {
            var _this = this;
            axios.post("/sc/findMajor?mid=0").then(function (response) {
                console.log(response);
                _this.mList = response.data;
            })
            axios.post("/sc/findGame").then(function (response) {
                console.log(response);
                _this.gList = response.data;
            })
        },
        gai:function () {
            var _this=this;
            var id=document.getElementById("maj").value;
            axios.post("/sc/findMajor?mid="+id).then(function (response) {
                _this.cList = response.data;
            })
        },
        upload:function () {
            var formData = new window.FormData;
            formData.append('file',document.querySelector('input[type=file]').files[0]);
            var options={
                url: '../sc/fileUpload',
                data: formData,
                method: 'post',
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            };
            var _this = this;
            axios(options).then(function (response) {
                if(response.data.flag){
                    alert(response.data.msg);
                    _this.imgaddress = response.data.imgaddress;
                }else {
                    alert(response.data.msg);
                }
            })
        },
        addStu:function () {
            var _this = this;
            var str = "";
            $(".cbox:checked").each(function(){
                str+=$(this).val()+","
            })
            axios.post("/sc/insertStudent?str="+str,_this.student).then(function (response) {
                if(response.data.flag){
                    alert(response.data.msg);
                    location.href="/main/toindex";
                }else {
                    alert(response.data.msg);
                }
            })

        }
    }
});
vm.init();