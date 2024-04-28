import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},

	// 注册
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			index: 0,
			title: '注册'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},

	// 权限路由
	{
		path: '/auth/table',
		name: 'auth_table',
		component: () => import('../views/nav/table.vue'),
		meta: {
			index: 0,
			title: '权限列表'
		}
	},
	{
		path: '/auth/view',
		name: 'auth_view',
		component: () => import('../views/nav/view.vue'),
		meta: {
			index: 0,
			title: '权限详情'
		}
	},

	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },





	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 普通用户路由
	{
		path: '/ordinary_users/table',
		name: 'ordinary_users_table',
		component: () => import('../views/ordinary_users/table.vue')
	},
	{
		path: '/ordinary_users/view',
		name: 'ordinary_users_view',
		component: () => import('../views/ordinary_users/view.vue')
	},
	// 普通管理者路由
	{
		path: '/general_manager/table',
		name: 'general_manager_table',
		component: () => import('../views/general_manager/table.vue')
	},
	{
		path: '/general_manager/view',
		name: 'general_manager_view',
		component: () => import('../views/general_manager/view.vue')
	},
	// 站点公告路由
	{
		path: '/site_announcement/table',
		name: 'site_announcement_table',
		component: () => import('../views/site_announcement/table.vue')
	},
	{
		path: '/site_announcement/view',
		name: 'site_announcement_view',
		component: () => import('../views/site_announcement/view.vue')
	},
	// 党建资讯路由
	{
		path: '/party_building_information/table',
		name: 'party_building_information_table',
		component: () => import('../views/party_building_information/table.vue')
	},
	{
		path: '/party_building_information/view',
		name: 'party_building_information_view',
		component: () => import('../views/party_building_information/view.vue')
	},
	// 党建活动路由
	{
		path: '/party_building_activities/table',
		name: 'party_building_activities_table',
		component: () => import('../views/party_building_activities/table.vue')
	},
	{
		path: '/party_building_activities/view',
		name: 'party_building_activities_view',
		component: () => import('../views/party_building_activities/view.vue')
	},
	// 党建通知路由
	{
		path: '/party_building_notice/table',
		name: 'party_building_notice_table',
		component: () => import('../views/party_building_notice/table.vue')
	},
	{
		path: '/party_building_notice/view',
		name: 'party_building_notice_view',
		component: () => import('../views/party_building_notice/view.vue')
	},
	// 心得体会路由
	{
		path: '/experience/table',
		name: 'experience_table',
		component: () => import('../views/experience/table.vue')
	},
	{
		path: '/experience/view',
		name: 'experience_view',
		component: () => import('../views/experience/view.vue')
	},
	// 思想汇报路由
	{
		path: '/thought/table',
		name: 'thought_table',
		component: () => import('../views/thought/table.vue')
	},
	{
		path: '/thought/view',
		name: 'thought_view',
		component: () => import('../views/thought/view.vue')
	},
	// 党费缴交路由
	{
		path: '/party_dues_payment/table',
		name: 'party_dues_payment_table',
		component: () => import('../views/party_dues_payment/table.vue')
	},
	{
		path: '/party_dues_payment/view',
		name: 'party_dues_payment_view',
		component: () => import('../views/party_dues_payment/view.vue')
	},
	// 党课信息路由
	{
		path: '/party_lesson_information/table',
		name: 'party_lesson_information_table',
		component: () => import('../views/party_lesson_information/table.vue')
	},
	{
		path: '/party_lesson_information/view',
		name: 'party_lesson_information_view',
		component: () => import('../views/party_lesson_information/view.vue')
	},
	// 签到信息路由
	{
		path: '/sign_in_information/table',
		name: 'sign_in_information_table',
		component: () => import('../views/sign_in_information/table.vue')
	},
	{
		path: '/sign_in_information/view',
		name: 'sign_in_information_view',
		component: () => import('../views/sign_in_information/view.vue')
	},
	// 请假信息路由
	{
		path: '/leave_information/table',
		name: 'leave_information_table',
		component: () => import('../views/leave_information/table.vue')
	},
	{
		path: '/leave_information/view',
		name: 'leave_information_view',
		component: () => import('../views/leave_information/view.vue')
	},
	// 院系类别路由
	{
		path: '/department_category/table',
		name: 'department_category_table',
		component: () => import('../views/department_category/table.vue')
	},
	{
		path: '/department_category/view',
		name: 'department_category_view',
		component: () => import('../views/department_category/view.vue')
	},
	// 党员信息路由
	{
		path: '/party_member_information/table',
		name: 'party_member_information_table',
		component: () => import('../views/party_member_information/table.vue')
	},
	{
		path: '/party_member_information/view',
		name: 'party_member_information_view',
		component: () => import('../views/party_member_information/view.vue')
	},
	// 成绩证书路由
	{
		path: '/certificate_of_achievement/table',
		name: 'certificate_of_achievement_table',
		component: () => import('../views/certificate_of_achievement/table.vue')
	},
	{
		path: '/certificate_of_achievement/view',
		name: 'certificate_of_achievement_view',
		component: () => import('../views/certificate_of_achievement/view.vue')
	},
	// 建议反馈路由
	{
		path: '/suggested_feedback/table',
		name: 'suggested_feedback_table',
		component: () => import('../views/suggested_feedback/table.vue')
	},
	{
		path: '/suggested_feedback/view',
		name: 'suggested_feedback_view',
		component: () => import('../views/suggested_feedback/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "高校学生党员管理系统-admin";
	document.title = title;
})

export default router
