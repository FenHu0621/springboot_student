var vm = new Vue({
    el:'#app',
    data:{
        list:[],
        page:{},
        pageNum:1,
        pageSize:5,
        student:{},
        ggList:[],
        gList:[]
    },
    methods:{
        selectAll:function () {
            var _this = this;
            axios.post("/sc/selectAll?pageNum="+_this.pageNum+"&pageSize="+_this.pageSize,_this.student).then(function (response) {
                _this.page = response.data;
                _this.list = response.data.list;
                _this.pageNum = response.data.pageNum;
            })
        },
        paging(pageNum){
            if(pageNum==0){
                pageNum=1
            }
            this.pageNum = pageNum;
            this.selectAll();
        },
        toadd:function () {
            location.href="/main/toadd"
        },
        del:function (id) {
            axios.post("/sc/deleteStu?id="+id).then(function (response) {
                if(response.data.flag){
                    alert(response.data.msg);
                    location.reload();
                }else {
                    alert(response.data.msg);
                }
            })
        },
        find:function (id) {
            this.gList=[];
            location.href="/main/toupdate?id="+id;
        }
    }
});
vm.selectAll();