package com.te.golms.service.implementation;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.te.golms.entity.Batch;
import com.te.golms.entity.Request;
import com.te.golms.entity.model.BatchModel;
import com.te.golms.entity.model.TechnologyModel;
import com.te.golms.repository.*;
import com.te.golms.response.BatchResponseModel;
import com.te.golms.service.EmailService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplementationTest {

    // Creating a FAKE, DUMMY, STUB and MOCK TEST DOUBLE using mock() method or @Mock annotation!
    @Mock
    private AdminRepository adminRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    private BatchRepository batchRepository = mock(BatchRepository.class);

    // Creating SPY TEST DOUBLE using spy() method!
    private MentorRepository mentorRepository = spy(MentorRepository.class);
    private RequestListRepository requestListRepository = mock(RequestListRepository.class);
    private TechnologyRepository technologyRepository = mock(TechnologyRepository.class);
    private GoLmsUserRepository goLmsUserRepository = mock(GoLmsUserRepository.class);
    private EmailService emailService = mock(EmailService.class);
    private PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    private ModelMapper modelMapper = mock(ModelMapper.class);

    @InjectMocks
    private AdminServiceImplementation adminServiceImplementation;
//    = new AdminServiceImplementation(
//            adminRepository,
//            employeeRepository,
//            batchRepository,
//            mentorRepository,
//            requestListRepository,
//            technologyRepository,
//            goLmsUserRepository,
//            emailService,
//            passwordEncoder,
//            modelMapper
//    );

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBatcheList_FakeTestDouble() {
        // Given
        List<Batch> batches = Lists.asList(
                Batch.builder().batchName("A").build(),
                Batch.builder().batchName("B").build(),
                new Batch[]{Batch.builder().batchName("C").build()}
        );

        List<BatchResponseModel> batchResponseModels = Lists.asList(
                BatchResponseModel.builder().batchName("A").build(),
                BatchResponseModel.builder().batchName("B").build(),
                new BatchResponseModel[]{BatchResponseModel.builder().batchName("C").build()}
        );

        // When
        Mockito.when(batchRepository.findAll()).thenReturn(batches);

        // Then
        System.out.println(adminServiceImplementation.getBatcheList().size());
        assertEquals(3, adminServiceImplementation.getBatcheList().size());
    }

    @Test
    void getBatcheList_FakeTestDouble_deReturn() {
        // Given
        List<Batch> batches = Lists.asList(
                Batch.builder().batchName("A").build(),
                Batch.builder().batchName("B").build(),
                new Batch[]{Batch.builder().batchName("C").build()}
        );

        List<BatchResponseModel> batchResponseModels = Lists.asList(
                BatchResponseModel.builder().batchName("A").build(),
                BatchResponseModel.builder().batchName("B").build(),
                new BatchResponseModel[]{BatchResponseModel.builder().batchName("C").build()}
        );

        // When
        // Mockito.when(batchRepository.findAll()).thenReturn(batches);
        doReturn(batches).when(batchRepository).findAll();

        // Then
        System.out.println(adminServiceImplementation.getBatcheList().size());
        assertEquals(3, adminServiceImplementation.getBatcheList().size());
    }

    @Test
    void saveBatch_verify_findByMentorId() {
        // Given
        HashSet<TechnologyModel> technologyModels = Sets.<TechnologyModel>newHashSet();
        technologyModels.add(TechnologyModel.builder().technologyName("Tech").build());
        BatchModel batchModel = BatchModel.builder()
                .batchName("A")
                .technologies(technologyModels)
                .mentorId("123")
                .build();

        // When
        adminServiceImplementation.saveBatch(batchModel);

        // Then
        // Verifying that findByMentorId() method was called or not
        verify(mentorRepository).findByMentorId(batchModel.getMentorId());
        // Verifying that findByMentorId() method was called 1 time or not
        verify(mentorRepository, Mockito.times(1)).findByMentorId(batchModel.getMentorId());
    }

    @Test
    void updateBatch() {
        // Given
        // Using spy() for MentorRepository!
        HashSet<TechnologyModel> technologyModels = Sets.<TechnologyModel>newHashSet();
        technologyModels.add(TechnologyModel.builder().technologyName("Tech").build());
        BatchModel batchModel = BatchModel.builder()
                .batchName("A")
                .technologies(technologyModels)
                .mentorId("123")
                .build();

        // When
        adminServiceImplementation.updateBatch(batchModel);

        // Then
        verify(batchRepository).findByBatchName(batchModel.getBatchName());
        verify(mentorRepository, times(1)).findByMentorId(batchModel.getMentorId());
    }

    @Test
    void addEmployeeToBatchModel() {
    }

    @Test
    void getRequestList() {

    }

    @Test
    void rejectRequest() {
    }

    @Test
    void saveMentor() {
    }

    @Test
    void getMentorList() {
    }

    @Test
    void deleteMentor() {
    }

    @Test
    void deleteBatch() {
    }
}