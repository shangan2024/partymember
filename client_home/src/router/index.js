import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue'
import login from '../views/account/login.vue';

Vue.use(VueRouter)

const routes = [
	// 主页ss
	{
		path: '/',
		name: 'index',
		component: index
	},
	// 登录
	{
		path: '/account/login',
		name: 'login',
		component: login
	},
	// 忘记密码
	{
		path: '/account/forgot',
		name: 'forgot',
		component: () => import('../views/account/forgot.vue')
	},
	// 注册账号
	{
		path: '/account/register',
		name: 'register',
		component: () => import('../views/account/register.vue')
	},
	// 媒体图片
	{
		path: '/media/image',
		name: 'media_image',
		component: () => import('../views/media/image.vue')
	},
	// 音乐
	{
		path: '/media/music',
		name: 'media_music',
		component: () => import('../views/media/music.vue')
	},
	// 媒体视频
	{
		path: '/media/video',
		name: 'media_video',
		component: () => import('../views/media/video.vue')
	},
	// 浏览网站







	
	
		
	
		
		// 站点公告列表路由
	{
		path: '/site_announcement/list',
		name: '/site_announcement_list',
		component: () => import('../views/site_announcement/list.vue')
	},
	
		// 站点公告详情路由
	{
		path: '/site_announcement/details',
		name: '/site_announcement_details',
		component: () => import('../views/site_announcement/details.vue')
	},
		
		// 党建资讯列表路由
	{
		path: '/party_building_information/list',
		name: '/party_building_information_list',
		component: () => import('../views/party_building_information/list.vue')
	},
	
		// 党建资讯详情路由
	{
		path: '/party_building_information/details',
		name: '/party_building_information_details',
		component: () => import('../views/party_building_information/details.vue')
	},
		
		// 党建活动列表路由
	{
		path: '/party_building_activities/list',
		name: '/party_building_activities_list',
		component: () => import('../views/party_building_activities/list.vue')
	},
	
		// 党建活动详情路由
	{
		path: '/party_building_activities/details',
		name: '/party_building_activities_details',
		component: () => import('../views/party_building_activities/details.vue')
	},
		
		// 党建通知列表路由
	{
		path: '/party_building_notice/list',
		name: '/party_building_notice_list',
		component: () => import('../views/party_building_notice/list.vue')
	},
	
		// 党建通知详情路由
	{
		path: '/party_building_notice/details',
		name: '/party_building_notice_details',
		component: () => import('../views/party_building_notice/details.vue')
	},
		
	
		
	
		
	
		
	
		
	
		
	
		
	
		
	
		
	
		
	
	
	// 用户路由
	{
		path: '/user/index',
		name: 'user_index',
		component: () => import('../views/user/index.vue')
	},
	// 基本信息
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue')
	},
	// 找回密码
	{
		path: '/user/password',
		name: 'user_password',
		component: () => import('../views/user/password.vue')
	},

	// 搜索
	{
		path: '/search',
		name: 'search',
		component: () => import('../views/search/index.vue')
	},
	// 局部搜索
	{
		path: '/search/details',
		name: 'search_details',
		component: () => import('../views/search/details.vue')
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.afterEach((to, from, next) => {
	let title = "高校学生党员管理系统-home";
	document.title = title;
	document.logo = "高校学生党员管理系统"
})

export default router
