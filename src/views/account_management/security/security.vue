<template>
    <div>
        <page-header title="安全设置">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为账户的安全设置
                </div>
            </template>
        </page-header>
        <page-main>
            <el-card>
                <div>
                    <el-carousel indicator-position="outside" :height="dataHeight">
                        <el-carousel-item v-for="item in 3" :key="item">
                            <h3 class="pageText">提示{{ item }}</h3>
                        </el-carousel-item>
                    </el-carousel>
                </div>
                <div>
                    <el-col :span="16">
                        <el-row>
                            <el-card class="pageCard" shadow="hover">
                                1模仿对象,阿里云后台安全中心
                            </el-card>
                        </el-row>
                        <el-row>
                            <el-card class="pageCard" shadow="hover">
                                2
                            </el-card>
                        </el-row>
                    </el-col>
                    <el-col :span="8">
                        <el-row>
                            <el-card class="pageCardRol" shadow="hover">
                                3
                            </el-card>
                        </el-row>
                    </el-col>
                </div>
                <div>
                    <el-row>
                        <el-col>
                            <el-card class="pageCard" shadow="hover">
                                4
                            </el-card>

                            <el-card shadow="hover">
                                5
                            </el-card>
                        </el-col>
                    </el-row>
                </div>
            </el-card>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    props: {
        dataHeight: {
            type: String,
            default: '120px'
        }
    },
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
<style>
.pageText {
    margin: 0 auto;
    text-align: center;
}
.pageCard {
    margin-bottom: 15px;
    margin-right: 10px;
}
.pageCardRol {
    margin-bottom: 15px;
    margin-right: 10px;
    height: 140px;
}
.carousel .item {
    height: 20px;
    background-color: #777;
}
.carousel-inner > .item > img {
    position: absolute;
    top: 0;
    left: 0;
    min-width: 100%;
    height: 200px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 15px;
    opacity: 0.75;
    line-height: 50px;
    height: 50px;
    margin: 0;
}
.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
</style>
