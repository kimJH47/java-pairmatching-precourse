package pairmatching.view;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import pairmatching.dto.PairMatchingDto;
import pairmatching.dto.PairResultDto;

public class ViewResolver {
    private final Map<Class<?>, Consumer<Object>> outputViewMappings = new HashMap<>();
    private final Map<Class<?>, Supplier<Object>> inputViewMappings = new HashMap<>();


    public ViewResolver(final InputView inputView, final OutputView outputView) {
        initInputViewMappings(inputView);
        initOutputViewMappings(outputView);
    }

    private void initInputViewMappings(final InputView inputView) {
        inputViewMappings.put(PairMatchingDto.class, inputView::readPairMatchingState);
    }

    private void initOutputViewMappings(final OutputView outputView) {
        outputViewMappings.put(PairResultDto.class, dto -> outputView.);
    }

    public <T> T inputViewResolve(final Class<T> type) {
        try {
            return type.cast(inputViewMappings.get(type).get());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public void outputViewResolve(final Object dto) {
        try {
            outputViewMappings.get(dto.getClass()).accept(dto);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
