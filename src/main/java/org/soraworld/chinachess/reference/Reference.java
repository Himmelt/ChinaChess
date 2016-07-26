/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.reference;

public final class Reference {

    public static final String MODID = "chinachess";
    public static final String VERSION = "1.3.0";
    public static final String NAME = "ChinaChess";
    public static final String ACMCVERSION = "1.7.10";
    public static final String CLIENT_PROXY_CLASS = "org.soraworld." + MODID + ".proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "org.soraworld." + MODID + ".proxy.ServerProxy";

    public static final class Blocks{

        // 空白棋子
        // 各类棋子
        public static final String chess = "chinaChess";
        // 空白棋盘
        // 各类棋盘
        public static final String board = "chessBoard";
    }

    public static final class Items{

        // 材料晶尘
        public static final String dust = "dust";
    }
}
