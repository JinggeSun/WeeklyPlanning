<template>
  <div class=main>
    <div class="left">
      <Left></Left>
    </div>
    <div class="right">
      <div class="top">
        <img src="img/banner.jpg">
      </div>
      <div class="buttom">
        <Right></Right>
      </div>
    </div>
  </div>
</template>
<script>
import Left from '../components/Left.vue';
import Right from '../components/Right.vue';
export default{
  components:{
    Left,
    Right
  }
}

</script>
<style>
/* 全局 */
*{
    padding: 0;
    margin: 0;
}
/* main */
.main{
  width: 1200px;
  margin: 20px auto;
}
/* left */
.left{
  width: 100px;
  float: left;
  margin-right: 10px;
}
/* right */
.right{
  width: 1000px;
  float: left;
  margin-left: 10px;
  height: 500px;
}
.top img{
  width: 1000px;
  height: 200px;
}

/* 公共 */
.left,.right{
  background-color: #F5F5F5;
  height: 500px;
}

</style>
