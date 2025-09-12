# ANPAN Android App

包括的なANPANサービスのAndroidアプリケーション - Kotlin + Jetpack Compose + MVVM + Clean Architectureで構築

## 概要

ANPANは、ソーシャルコマース、ウォレット、AI、チャット、エンターテイメントなど、複数のサービスを統合したプラットフォームです。

## 主要機能

### コア機能
- **認証**: Firebase Auth + Google + ANPAN ID SSO
- **ソーシャルコマース**: 投稿、フィード、商品閲覧・購入、カート、チェックアウト
- **ウォレット (Kabu Pay)**: Web3Jウォレット、残高管理、決済、取引履歴
- **AI (ANPAN Brain)**: 推薦エンジン、自然言語検索
- **Chattie**: ビデオ通話、チャット、チャットコマース

### 拡張モジュール
- **ANPAN Music**: 音楽ストリーミング、プレイリスト、暗号資産ロイヤリティ
- **ANPAN TV**: 動画配信、ライブ配信、投げ銭
- **ANPAN Games**: ミニゲーム、ランキング、報酬
- **ANPAN Map**: 地図、店舗検索、ソーシャルチェックイン
- **ANPAN Realty**: 不動産検索・契約、ブロックチェーン登記
- **AgreeAgri**: 農業支援AI、収穫予測、農作物マーケットプレイス
- **PotentialPrime**: AI人材マッチング、ブロックチェーンスキル証明
- **Scribia**: AIライティング・翻訳・要約ツール
- **UUU**: メタバース教育、授業配信、学習成果証明
- **U**: バーチャルワールド、音楽ライブ、バーチャルショップ
- **ChronoSphere**: 時間管理、Maeda理論ベースの時間再構築
- **CosmosGate**: 宇宙旅行予約、宇宙教育VR体験
- **KAGO**: EV・自動運転モビリティ連携
- **Lyra**: 死後産業、デジタルレガシー、人格再現
- **POPOL**: 脳波センサー・触覚デバイス・ホログラムUI連携
- **Aethelive**: エンタメ興行、チケット販売、ファンクラブSNS

## ユーザータイプ

### ゲストユーザー
- 投稿、コメント、いいね、シェア、商品閲覧・購入が可能
- ウォレット利用不可、リワード獲得不可

### 登録ユーザー
- 全機能利用可能
- ウォレット作成、残高管理、リワード獲得

## アーキテクチャ

### モジュール構成
```
app/                    # メインアプリケーション
core/
  ├── common/          # 共通処理
  ├── network/         # ネットワーク層
  ├── database/        # データベース層
  ├── designsystem/    # デザインシステム
  └── featureflags/    # フィーチャーフラグ
feature/
  ├── auth/            # 認証
  ├── socialcommerce/  # ソーシャルコマース
  ├── wallet/          # ウォレット
  ├── ai/              # AI機能
  ├── chattie/         # チャット・ビデオ通話
  ├── music/           # 音楽ストリーミング
  ├── tv/              # 動画配信
  ├── games/           # ゲーム
  ├── map/             # 地図
  └── [その他の拡張モジュール]
```

### 技術スタック
- **言語**: Kotlin
- **UI**: Jetpack Compose
- **アーキテクチャ**: MVVM + Clean Architecture
- **DI**: Hilt
- **ネットワーク**: Retrofit + OkHttp
- **データベース**: Room
- **認証**: Firebase Auth
- **ウォレット**: Web3J
- **動画**: ExoPlayer
- **ビデオ通話**: Agora SDK
- **地図**: Mapbox
- **決済**: Stripe

## セットアップ

### 前提条件
- Android Studio Arctic Fox以降
- JDK 17
- Android SDK API 34
- Git

### ビルド手順

1. リポジトリをクローン
```bash
git clone <repository-url>
cd anpan-android
```

2. キーストアを生成
```bash
./scripts/generate-keystore.sh debug
```

3. プロジェクトをビルド
```bash
./gradlew build
```

4. テストを実行
```bash
./gradlew test
```

5. Lintチェック
```bash
./gradlew lint
```

### 環境変数
以下の環境変数を設定してください：

```bash
# リリースビルド用
export KEYSTORE_PASSWORD="your_keystore_password"
export KEY_ALIAS="your_key_alias"
export KEY_PASSWORD="your_key_password"

# Firebase設定
export FIREBASE_APP_ID="your_firebase_app_id"
export FIREBASE_SERVICE_ACCOUNT="your_service_account_json"
```

## API設定

APIのベースURLはプレースホルダーとして設定されています：

```kotlin
buildConfigField("String", "API_BASE_URL", "\"https://api.anpan.placeholder.com/\"")
buildConfigField("String", "WEBSOCKET_URL", "\"wss://ws.anpan.placeholder.com/\"")
```

実際のAPIエンドポイントに変更してください。

## CI/CD

GitHub Actionsを使用したCI/CDパイプラインが設定されています：

- **Lint**: コード品質チェック
- **Test**: ユニットテスト・インストゥルメンテーションテスト
- **Build**: デバッグ・リリースAPKビルド
- **Security**: Trivyセキュリティスキャン
- **Deploy**: Firebase App Distributionへのデプロイ

### APK署名

リリースAPKはv2/v3署名で署名されます：

```bash
apksigner sign \
  --ks keystore/anpan-release.keystore \
  --ks-key-alias $KEY_ALIAS \
  --v2-signing-enabled true \
  --v3-signing-enabled true \
  app-release.apk
```

## 開発ガイドライン

### コーディング規約
- Kotlinコーディング規約に従う
- Clean Architectureパターンを維持
- 各機能モジュールは独立性を保つ
- UIはJetpack Composeで実装

### テスト
- ユニットテスト: `src/test/`
- インストゥルメンテーションテスト: `src/androidTest/`
- UIテスト: Compose Testing

### フィーチャーフラグ
新機能はフィーチャーフラグで制御：

```kotlin
if (featureFlagManager.isFeatureEnabled(Constants.FEATURE_NEW_FEATURE)) {
    // 新機能の実装
}
```

## ライセンス

[ライセンス情報を記載]

## 貢献

プルリクエストやイシューの報告を歓迎します。

## サポート

技術的な質問やサポートについては、開発チームまでお問い合わせください。
