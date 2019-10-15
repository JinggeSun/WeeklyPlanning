<template>
  <div name="show">
    <ul class="goodList">
      <li v-for="good in list">
        <img v-bind:src="good.img">
        <p>{{good.goodName}}</p>
      </li>
    </ul>
  </div>
</template>
<style>
  .goodList li{
    width: 100px;
    height: 100px;
    font-size: 9px;
    color: red;
    margin-bottom: 30px;
    list-style: none;
    float: left;
  }
</style>
<script>
  export default{
    name:"show",
    data(){
      var _this = this;
      var url = "";
      if (_this.goodId == 1){
        url = "json/dn.json";
      }else{
        url = "json/dn.json";
      }
      this.$http.get(url).then(function(res){
        _this.list = res.data
      })
      return{
        list:[]
      }
    },
    props:{
      goodId:Number
    },
    wathc:{
      goodId(){
        var _this = this;
        var url = "";
        if (_this.goodId == 1){
          url = "json/dn.json";
        }else{
          url = "json/dn.json";
        }
        this.$http.get(url).then(function(res){
          _this.list = res.data
        })
        return{
          list:[]
        }
      }
    }
  }
</script>
