package lambda.designing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 関心の分離 (Predicate を使って判定する)
 */
public class PredicateTest {

    public static int totalAssetValues(List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalBondValues(List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset ->
                        asset.getType() == AssetType.BOND ? asset.getValue() : 0)
                .sum();
    }

    public static int totalStockValues(List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset ->
                        asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
                .sum();
    }

    public static int totalAssetValues(List<Asset> assets, Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }


    List<Asset> assets = Arrays.asList(
            new Asset(AssetType.BOND, 1000),
            new Asset(AssetType.BOND, 2000),
            new Asset(AssetType.STOCK, 3000),
            new Asset(AssetType.STOCK, 4000)
    );

    @Test
    @DisplayName("Assetの合計")
    void testTotalAssetValues() {
        assertEquals(10000, totalAssetValues(assets));
        assertEquals(10000, totalAssetValues(assets, asset -> true));
    }

    @Test
    @DisplayName("Bondの合計")
    void testTotalBondValues() {
        assertEquals(3000, totalBondValues(assets));
        assertEquals(3000, totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND));
    }

    @Test
    @DisplayName("Stockの合計")
    void testTotalStockValues() {
        assertEquals(7000, totalStockValues(assets));
        assertEquals(7000, totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK));
    }
}
