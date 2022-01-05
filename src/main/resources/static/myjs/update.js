var vm = new Vue({
    el:'#update',
    data:{
        mList:[],
        cList:[],
        gList:[],
        student:{},
        imgaddress:'',
        mid:'',
        cid:'',
        ggList:[]
    },
    methods:{
        init:function () {
            var _this = this;
            axios.post("/sc/findMajor?mid=0").then(function (response) {
                _this.mList = response.data;
            })
            axios.post("/sc/findGame").then(function (response) {
                _this.gList = response.data;
            })
            axios.post("/sc/findStudentById").then(function (response) {
                _this.student = response.data.student;
                _this.imgaddress = response.data.student.url;
                _this.mid = response.data.major.mid;
                _this.cid = response.data.major.cid;
                axios.post("/sc/findMajor?mid="+_this.mid).then(function (response) {
                    _this.cList = response.data;
                })
                var ggList2=response.data.gList;
                for (var i = 0; i <ggList2.length ; i++) {
                    _this.ggList.push(ggList2[i].gid)
                }
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
        update:function () {
            var _this = this;
            var str = "";
            $(".cbox:checked").each(function(){
                str+=$(this).val()+","
            })
            var backMid=document.getElementById("maj").value;
            var backCid=document.getElementById("cou").value;
            axios.post("/sc/updateStudent?str="+str+"&backMid="+backMid+"&backCid="+backCid,_this.student).then(function (response) {
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