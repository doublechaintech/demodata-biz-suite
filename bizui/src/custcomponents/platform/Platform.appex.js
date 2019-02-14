import PlatformBizApp from '../../bizcomponents/platform/Platform.app'

import React from 'react'
import { connect } from 'dva'

import styles from './Platform.appex.less'


import About from '../about/About'
import appLocaleName from '../../common/Locale.tool'


const isMenuItemForDisplay = (item, targetObject, targetComponent) => {

  //if this item for display, returning true means display it
  return true

}


class PlatformBizAppEx extends React.PureComponent {
  
  extraRoutesFunc=()=>{

    return [{path:'/platform/:id/about/:seq', component:About}];

  }
  render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     //console.log("this.extraRoutesFunc------------",this.extraRoutesFunc());
     return (
      <PlatformBizApp extraRoutesFunc={this.extraRoutesFunc} isMenuItemForDisplayFunc={isMenuItemForDisplay} {...this.props}/>
     )
   }
}


export default connect(state => ({  
  customized:'yes',
}))(PlatformBizAppEx)


/*

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  platform: state._platform,
  extra:'yes',
  ...state,
}))(PlatformBizAppEx)


import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,
} from 'antd'
import DocumentTitle from 'react-document-title'

import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Platform.appex.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


*/

