package cn.javayong.magic.admin.tiny.model;

import java.util.List;
import java.util.Set;

/**
 * 权限信息响应模型
 */
public class PermissionInfoResponse {
    private Set<String> permissions;
    private List<String> roles;
    private UserInfo user;
    private List<Menu> menus;

    // Getters and Setters
    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    /**
     * 用户信息内部类
     */
    public static class UserInfo {
        private long id;
        private String avatar;
        private String nickname;
        private long deptId;

        // Getters and Setters
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getDeptId() {
            return deptId;
        }

        public void setDeptId(long deptId) {
            this.deptId = deptId;
        }
    }

    /**
     * 菜单信息内部类
     */
    public static class Menu {
        private String path;
        private String name;
        private String component;
        private MenuMeta meta;

        // Getters and Setters
        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public MenuMeta getMeta() {
            return meta;
        }

        public void setMeta(MenuMeta meta) {
            this.meta = meta;
        }

        /**
         * 菜单元信息内部类
         */
        public static class MenuMeta {
            private String title;
            private String icon;
            private boolean hidden;
            private boolean noCache;

            // Getters and Setters
            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public boolean isHidden() {
                return hidden;
            }

            public void setHidden(boolean hidden) {
                this.hidden = hidden;
            }

            public boolean isNoCache() {
                return noCache;
            }

            public void setNoCache(boolean noCache) {
                this.noCache = noCache;
            }
        }
    }
}