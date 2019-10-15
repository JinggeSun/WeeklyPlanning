<template>
  <div>
    <div class="title">热门推荐</div>
    <ul class="menu">
      <li @click="menu01">电脑</li>
      <li @click="menu02">手机</li>
      <li>手机</li>
      <li>手机</li>
      <li>手机</li>
      <li>手机</li>
      <li>手机</li>
    </ul>
  </div>
</template>
<script>
import Msg from './msg.js'

export default{
  methods:{
    menu01:function(){
        Msg.$emit("val","1");
    },
    menu02:function(){
        Msg.$emit("val","2");
    }
  }
}
</script>
<style>
  .title{
    width: 100px;
    color: red;
  }
  .menu li{
    list-style: none;
    height: 50px;
    margin-bottom: 2px;
    background-color: white;
    line-height: 50px;
    cursor: pointer;
  }
</style>
